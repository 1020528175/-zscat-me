package com.zsCat.common.lucene;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Description:s
 *
 * @author Jin
 * @create 2017-05-18
 **/
@Configuration
public class LuceneConfiguration {


    @Bean
    public LuceneDao luceneUtil() throws IOException {
        LuceneDao luceneDao = new LuceneDao();
        luceneDao.setIndexDer("D:\\hulu\\webappchat\\zscat\\luence");
        return luceneDao;
    }

}
