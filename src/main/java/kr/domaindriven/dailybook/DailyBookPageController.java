package kr.domaindriven.dailybook;

import kr.domaindriven.dailybook.record.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     후원금 관리 화면 입출력 서버측 접점
 * </p>
 *
 * @author Younghoe Ahn
 * @author Jerry Ahn
 */
@Controller
public class DailyBookPageController {

    /*
     * templates 하위 디렉토리 이름을 Controller별로 한번에 지정하기 위해 사용
     */
    private final String APP_DIR = "dailybook/";

    @Autowired
    private RecordRepository recordRepository;

    /**
     * <p>후원금 관리 목록에 한 줄에 해당하는 데이터를 입력하는 화면 출력</p>
     *
     * @param model
     * @return
     */
    @RequestMapping(value = APP_DIR + "add", method = RequestMethod.GET)
    public String addRecord(Model model) {
        // command 객체
        RecordForm formBackingObject = new RecordForm();
        System.out.println("Form date: " + formBackingObject.getDate());
        formBackingObject.setDate(LocalDateTime.now());
        model.addAttribute("record", formBackingObject);

        return APP_DIR + "add";
    }


    /**
     * <p>후원금 관리 목록에 한 줄을 추가하는 행위</p>
     *
     * @param model
     * @return
     */
    @RequestMapping(value = APP_DIR + "add", method=RequestMethod.POST)
    public String recordAdded(@ModelAttribute RecordForm form, BindingResult result, Model model) {

        Record record = new Record();

        // TODO convert hard-cord check to @VALID

        //날짜를 위한 추가부분
        if(form.getDate() == null) {
            System.out.println("Form.date: " + form.getDate());
            model.addAttribute("record", form);
            return APP_DIR + "add";
        }else {
            System.out.println("Form.date: " + form.getDate());
            record.setDate(form.getDate());
        }
        //금액을 위한 추가부분, 음수면 지출 그외에는 수입
        if(form.getAmount() == null){
            System.out.println("Form.amount: " + form.getAmount());
            model.addAttribute("record", form);
            return APP_DIR + "add";
        }else if(form.getAmount() < 0){
            System.out.println("Form.amount: " + form.getAmount());
            record.setRevenueOrExpense(RecordType.지출);
            record.setAmount(new Won(form.getAmount()));
        }else {
            System.out.println("Form.amount: " + form.getAmount());
            record.setRevenueOrExpense(RecordType.수입);
            record.setAmount(new Won(form.getAmount()));
        }
        //범주(카테고리)를 위한 부분
       if(form.getCategory() == null){
            System.out.println("Form.category: " + form.getCategory());
            model.addAttribute("record", form);
            return APP_DIR + "add";
        }else if(form.getCategory().equals(RecordCategory.위키유지비)){
            System.out.println("Form.category: " + form.getCategory());
            record.setCategory(RecordCategory.위키유지비);
        }else {
            System.out.println("Form.category: " + form.getCategory());
            record.setCategory(RecordCategory.후원금);
        }

        //잔액(balance)를 위한 부분
        recordRepository.findById(1l);

        Won balance = new Won(0);


        //적요(Summary)를 위한 부분
        if(form.getSummary() == null){
            System.out.println("Form.category: " + form.getCategory());
            model.addAttribute("record", form);
            return APP_DIR + "add";
        }else{
            System.out.println("Form.category: " + form.getCategory());
            record.setSummary(form.getSummary());
        }

        recordRepository.save(record);
        model.addAttribute("record", form);

        return APP_DIR + "result";

     /*   if(result.hasErrors())
            return APP_DIR + "add";
        else
            return APP_DIR + "result";*/
    }


    /**
     * <p>후원금 관리 첫 화면 즉, 목록이 나오는 화면 출력</p>
     * @param model
     * @return
     */
    @RequestMapping(value = APP_DIR + "list", method = RequestMethod.GET)
    public String list(Model model){
        List<Record> recordList = new ArrayList<Record>();
        for (Record record:recordRepository.findAll()) {
            recordList.add(record);
        }
        model.addAttribute("list", recordList);
        return APP_DIR + "list";
    }

    // TODO 향후 구현 완료 후에 javadoc 주석 보강

    @RequestMapping(value = "dailybook/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable Long id,Model model){
        Record oldRecord = recordRepository.findById(id);
        model.addAttribute("oldRecord",oldRecord);
        System.out.println(oldRecord);
        return APP_DIR + "update";
    }

    @RequestMapping(value = "dailybook/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Long id,@ModelAttribute Record record,Model model){
        recordRepository.save(record);
        System.out.println(record);
        return APP_DIR +"result";
    }
}