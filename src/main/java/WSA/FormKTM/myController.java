/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WSA.FormKTM;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Asus
 */
@Controller
public class myController {
      @RequestMapping("/myPage")
    public String inputData( @RequestParam(value = "varName") String nameInput,
            @RequestParam(value = "varNIM") String nimInput,
            @RequestParam(value = "varProdi") String prodiInput,
            @RequestParam(value = "varEmail") String emailInput,
            @RequestParam(value = "varImage") MultipartFile imgInput,
            Model input
    ) throws IOException{ byte[] img = imgInput.getBytes();
        String encodeImage = Base64.encodeBase64String(img);
        String imageInput = "data:image/png;base64,".concat(encodeImage);
        
        input.addAttribute("name", nameInput);
        input.addAttribute("nim", nimInput);
        input.addAttribute("prodi", prodiInput);
        input.addAttribute("email", emailInput);
        input.addAttribute("img", imageInput);
        
        return "viewpage";
    }
}
