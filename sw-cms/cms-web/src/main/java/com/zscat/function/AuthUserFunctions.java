package com.zscat.function;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.cms.model.CmsArticle;
import com.zscat.cms.model.CmsCategory;
import com.zscat.conf.JbaseFunctionPackage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import com.zscat.cms.service.CmsArticleService;
import com.zscat.cms.service.CmsCategoryService;
import javax.annotation.Resource;
import java.util.List;


@Service("auth")
public class AuthUserFunctions implements JbaseFunctionPackage {
    @Reference(version = "1.0.0")
    private CmsArticleService CmsArticleService;
    @Reference(version = "1.0.0")
    private CmsCategoryService  CmsCategoryService;

    public List<CmsArticle> getArticleByCate(Long id){
        CmsArticle record=new CmsArticle();
        record.setCategoryId(id);
        return CmsArticleService.select(record, "createdate desc");
    }
    public List<CmsCategory> getCateGory(String model){
        CmsCategory CmsCategory=new CmsCategory();
        CmsCategory.setIsshow(1);
        CmsCategory.setModule(model);
        return CmsCategoryService.select(CmsCategory);
    }
}
