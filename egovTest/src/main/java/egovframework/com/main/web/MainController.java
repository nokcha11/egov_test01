package egovframework.com.main.web;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.main.service.MainService;
import egovframework.com.util.SHA256;

@Controller
public class MainController {

   @Resource(name="MainService")
   private MainService mainService;
   SHA256 sha256 = new SHA256();
   
   
   @RequestMapping("/main.do")
   public String main() {
      return "main/main";
   }

   @RequestMapping("/login.do")
   public String login() {
      return "login";
   }
   
   @RequestMapping("/join.do")
   public String join() {
      return "join";
   }
   
   @RequestMapping("/member/idChk.do")
   public ModelAndView idChk(@RequestParam HashMap<String, Object> paramMap) {
      ModelAndView mv = new ModelAndView();
   
      int idChk = 0;
      idChk = mainService.selectIdChk(paramMap);
      
      mv.addObject("idChk", idChk);
      mv.setViewName("jsonView");
      return mv;
   }
   
   @RequestMapping("/member/insertMember.do")
   public ModelAndView insertMember(@RequestParam HashMap<String, Object> paramMap) throws Exception{
      ModelAndView mv = new ModelAndView();
      System.out.println(paramMap.toString());
      String pwd = paramMap.get("accountPwd").toString();
      paramMap.replace("accountPwd", sha256.encrypt(pwd));
      //paramMap.replace("accountPwd", sha256.encrypt(pwd));
      String accountEmail = paramMap.get("email").toString() + "@" + paramMap.get("emailAddr").toString();
      paramMap.put("accountEmail", accountEmail);
      System.out.println(paramMap.toString());
      int resultChk = 0;
      resultChk = mainService.insertMember(paramMap);
      
      mv.addObject("resultChk", resultChk);
      mv.setViewName("jsonView");
      return mv;
   }
}
