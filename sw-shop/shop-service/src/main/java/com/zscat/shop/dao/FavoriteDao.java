package com.zscat.shop.dao;

import com.zscat.shop.domain.FavoriteDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-21 11:21:45
 */
@Mapper
public interface FavoriteDao {

	FavoriteDO get(Long id);
	
	List<FavoriteDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FavoriteDO favorite);
	
	int update(FavoriteDO favorite);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<FavoriteDO> userFavorite(Map<String, Object> map);

	List<FavoriteDO> userTopicFavorite(Map<String, Object> map);
}
