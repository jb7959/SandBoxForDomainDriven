package kr.domaindriven.dailybook;

import kr.domaindriven.dailybook.record.Record;
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
 * @author jerry
 */
@Controller
public class DailyBookPageController {

    /**
     * <p>templates 하위 디렉토리 이름을 Controller별로 한번에 지정하기 위해 사용</p>
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
        model.addAttribute("record", new Record());

        return APP_DIR + "add";
    }


    /**
     * <p>후원금 관리 목록에 한 줄을 추가하는 행위</p>
     *
     * @param model
     * @return
     */
    @RequestMapping(value = APP_DIR + "add", method=RequestMethod.POST)
    public String recordAdded(@ModelAttribute Record record, BindingResult result, Model model) {

        // TODO convert hard-cord check to @VALID
        if(record.getDate() == null){
            System.out.println("#########" + record.getDate());
            return APP_DIR + "add";
        }

        System.out.println("#########" + record.getDate());

        recordRepository.save(record);
        model.addAttribute("record", record);

        if(result.hasErrors())
            return APP_DIR + "add";
        else
            return APP_DIR + "result";
    }


    /**
     * <p>@{link Record}의 date 속성을 초까지 포함한 현재시각으로 설정</p>
     *
     * @see <p href="http://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#dynamic-fields">
     *     7.6 Dynamic fields</p>
     * @param record
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = APP_DIR + "add", params = {"setDateAsNow"})
    public String setDateAsNow(final Record record, final BindingResult bindingResult){
        record.setDate(LocalDateTime.now());
        return APP_DIR + "add";
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

    @RequestMapping(value = "datatables", method = RequestMethod.GET)
    public String datatables(Model model){
        List<Record> recordList = new ArrayList<Record>();
        for (Record record:recordRepository.findAll()) {
            recordList.add(record);
        }
        model.addAttribute("list", recordList);
        return APP_DIR + "datatables";
    }


    @RequestMapping("list/{id}")
    public String list(@PathVariable Long id, Model model){
        List<Record> recordList = new ArrayList<Record>();
        recordList.add(recordRepository.findById(id));
        model.addAttribute("list", recordList);
        return APP_DIR + "list";    //TODO From ftl To thymeleaf
    }

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