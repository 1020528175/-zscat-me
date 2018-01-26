package com.zscat.shop.service;


import com.zsCat.common.base.Tree;
import com.zscat.shop.domain.TGoodsClassDO;


import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public interface TGoodsClassService {
	
	TGoodsClassDO get(Long id);
	
	List<TGoodsClassDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TGoodsClassDO tGoodsClass);
	
	int update(TGoodsClassDO tGoodsClass);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    Tree<TGoodsClassDO> getTree();
}
