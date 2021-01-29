package com.wuzx.validation.controller;


import com.wuzx.validation.enums.ResultCode;
import com.wuzx.validation.exception.ApiException;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Locale;

@RestController()
@RequestMapping("/API/log")
public class UploadController {


    private MessageSource messageSource;

    /**
     * 初始化
     *
     * @return
     */
    private MessageSource initMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i18n/project");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600);
        return messageSource;
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        if (messageSource == null) {
            messageSource = initMessageSource();
        }
        String result = null;
        if(file.isEmpty()){
            result= messageSource.getMessage("fileupload.failed",null,getLocal());
        }

        String fileName=file.getOriginalFilename();
        String filePath="/mnt/f/DeviceLogs/";
        File dest=new File(filePath,fileName);
        try {
            file.transferTo(dest);
            result=messageSource.getMessage("fileupload.success",null,getLocal());
        }catch (Exception e){
            throw new ApiException(111,result);
        }
         return result;
    }

    public Locale getLocal(){
        //默认没有就是请求地区的语言
      return  Locale.CHINA;
    }
}
