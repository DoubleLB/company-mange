package org.example.company.pub.api;

import lombok.extern.slf4j.Slf4j;
import org.example.company.common.CompanyConstants;
import org.example.company.common.Result;
import org.example.company.pub.dao.PublicDao;
import org.example.company.pub.model.Department;
import org.example.company.pub.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Slf4j
@Transactional
@RestController
@RequestMapping("/public")
public class PublicAPI {


    @GetMapping("/img/{imgname}")
    public void img(@PathVariable String imgname, OutputStream out) throws IOException {//@说明参数来源于路径中

        String path = CompanyConstants.UPLOAD_DIR + "/" + imgname;
        InputStream in = new FileInputStream(path);
        byte[] b = new byte[1024 * 500];
        int len = -1;
        while ((len = in.read(b)) != -1) {
            out.write(b, 0, len);
        }
        out.flush();
        out.close();
        in.close();
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        String filename = UUID.randomUUID().toString().replace("-", "")+".jpg";
        log.debug("filename=======>{}", filename);


        InputStream in = null;
        OutputStream out = null;
        out = null;
        try {
            in = file.getInputStream();
            out = new FileOutputStream(CompanyConstants.UPLOAD_DIR + "/" + filename);

            byte[] b = new byte[1024 * 500];
            int len = -1;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.flush();
            return Result.OK("上传成功", filename);
        } finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                if (in != null) in.close();
            }
        }

    }

    @Autowired
    private PublicDao publicDao;

    @GetMapping("/d")
    public Result<List<Department>> dList() {
        List<Department> list = publicDao.findDepartment();
        return Result.OK(list);
    }

    @GetMapping("/r")
    public Result<List<Role>> rList() {
        List<Role> list = publicDao.findRole();
        return Result.OK(list);
    }
}
