package com.hope.firstsb.controller;

import com.hope.firstsb.support.Response;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwh
 */

@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController {
    @GetMapping("/file")
    public String file() {
        return "file";
    }

    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return Response.fail().addMsg("参数错误");
        }
        List<Map<String, String>> results = new ArrayList<>();
        for (MultipartFile file : files) {
            // TODO Spring Mvc 提供的写入方式
            file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\uploads\\" + file.getOriginalFilename()));
            Map<String, String> map = new HashMap<>(16);
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize() + "");
            results.add(map);
        }
        return Response.success().addData(results).addMsg("上传成功");
    }
}
