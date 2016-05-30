package me.jiangcai.loveport.controller;

import me.jiangcai.loveport.TestBase;
import me.jiangcai.loveport.page.IndexPage;
import me.jiangcai.loveport.repository.NurseRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author CJ
 */
public class IndexControllerTest extends TestBase {

    @Autowired
    private NurseRepository nurseRepository;

    @Test
    public void index() throws Exception {
        driver.get("http://localhost/");
        IndexPage page = initPage(IndexPage.class);

        assertThat(page.findMenuLiByClass("fa-home").getAttribute("class"))
                .contains("active");


        assertThat(page.findNursesInfo().getValue().getText())
                .isEqualTo("0");

        // 随意添加吧
//        int count = 1001;
//        while (nurseRepository.count()<count){
//            Nurse nurse = new Nurse();
//            nurse.setUsername(UUID.randomUUID().toString());
//            nurseRepository.save(nurse);
//        }
//
//        page.refresh();
//        assertThat(page.findNursesInfo().getValue().getText())
//                .isEqualTo("0");
    }

}