package com.zscat.rabbit.object;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zsCat.common.base.RabbitMsg;
import com.zscat.shop.domain.JifendataDO;
import com.zscat.shop.domain.TMemberDO;
import com.zscat.shop.service.JifendataService;
import com.zscat.shop.service.TMemberService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@RabbitListener(queues = "zscat")
public class ObjectReceiver {

    @Reference(version = "1.0.0")
    private JifendataService jifendataService;
    @Reference(version = "1.0.0")
    private TMemberService tMemberService;
    @RabbitHandler
    public void process(RabbitMsg msg) {
        String btype = msg.getType();
        Map map = msg.getMap();
        System.out.println("Receiver object : " + btype);
        System.out.println("Receiver object : " + map);
        switch (btype) {
            case "addjifen": //添加积分
                if (map.get("userid")!=null){
                    JifendataDO jifendata = new JifendataDO();
                    jifendata.setAddcount((Integer) map.get("count"));
                    jifendata.setSource((String) map.get("msg"));
                    jifendata.setCreatedate(new Date());
                    jifendata.setUserid((Long) map.get("userid"));
                    jifendataService.save(jifendata);
                    TMemberDO m = tMemberService.get((Long) map.get("userid"));
                    m.setJifen(m.getJifen()+(Integer) map.get("count"));
                    tMemberService.update(m);
                }
                break;

            default: {
                System.out.println("unknown btype="+btype);

            }
        }
    }
}
