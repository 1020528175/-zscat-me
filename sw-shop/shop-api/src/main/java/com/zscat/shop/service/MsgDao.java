package com.zscat.shop.service;


import com.zscat.shop.domain.Msg;

/**
 * Created by summer on 2017/5/5.
 */
public interface MsgDao {

    public void saveMsg(Msg user);

    public Msg findMsgByMsgName(String userName);

    public int updateMsg(Msg user);

    public void deleteMsgById(Long id);

}
