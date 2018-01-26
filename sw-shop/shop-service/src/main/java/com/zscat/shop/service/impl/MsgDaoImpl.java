package com.zscat.shop.service.impl;

import com.zscat.shop.domain.Msg;
import com.zscat.shop.service.MsgDao;
import com.mongodb.WriteResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created by summer on 2017/5/5.
 */
@Component
public class MsgDaoImpl implements MsgDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param user
     */
    @Override
    public void saveMsg(Msg user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param userName
     * @return
     */
    @Override
    public Msg findMsgByMsgName(String userName) {
        Query query=new Query(Criteria.where("username").is(userName));
        Msg user =  mongoTemplate.findOne(query , Msg.class);
        return user;
    }

    /**
     * 更新对象
     * @param user
     */
    @Override
    public int updateMsg(Msg user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("username", user.getUsername()).set("type", user.getType());
        //更新查询返回结果集的第一条
        WriteResult result =mongoTemplate.updateFirst(query,update,Msg.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,Msg.class);
        if(result!=null)
            return result.getN();
        else
            return 0;
    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deleteMsgById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Msg.class);
    }
}
