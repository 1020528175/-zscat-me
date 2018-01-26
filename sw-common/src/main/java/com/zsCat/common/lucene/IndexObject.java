package com.zsCat.common.lucene;


import java.io.Serializable;

/**
 * Description:索引对象
 *
 * @author Jin
 * @create 2017-05-19
 **/
public class IndexObject implements Comparable<IndexObject>,Serializable{
	
	private Long id;

	private String title ="1";

	private String keywords="1";

	private String descripton="1";

	private String postDate;

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	private String url="1";
	private String col1="1";
	private String col2="1";
	private String col3="1";

	/*相似度*/
	private float score=0.1f;

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getScore() {
		return score;
	}

	public  void setScore(float score) {
		this.score = score;
	}


	
	public IndexObject() {
		super();
	}

	public IndexObject(Long _id, String _keywords, String _descripton, String _postDate, float _score) {
		super();
		this.id = _id;
		this.keywords = _keywords;
		this.score = _score;
		this.descripton=_descripton;
		this.postDate=_postDate;
	}
	@Override
	public int compareTo(IndexObject o) {
		if(this.score < o.getScore()){
			return 1;
		}else if(this.score > o.getScore()){
			return -1;
		}
		return 0;
	}
	
	
}
