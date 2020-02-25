package com.github.biuld.model;


import javax.persistence.Column;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;

@Data
public class TreeHole {

	@Id
	@ApiModelProperty(value = "id", position = 0)
  @Column(name = "id" )
	private Integer id;

	@ApiModelProperty(value = "id", position = 1)
  @Column(name = "mid" )
	private String mid;

	@ApiModelProperty(value = "id", position = 2)
  @Column(name = "bid" )
	private String bid;

	@ApiModelProperty(value = "内容", position = 3)
  @Column(name = "text" )
	private String text;

	@ApiModelProperty(value = "存储时间", position = 4)
  @Column(name = "store_at" )
	private java.time.LocalDateTime storeAt;

	@ApiModelProperty(value = "创建时间", position = 5)
  @Column(name = "created_at" )
	private java.time.LocalDateTime createdAt;

	@ApiModelProperty(value = "点赞次数", position = 6)
  @Column(name = "like_count" )
	private Long likeCount;

	@ApiModelProperty(value = "转发次数", position = 7)
  @Column(name = "repost_count" )
	private Long repostCount;

	@ApiModelProperty(value = "评论次数", position = 8)
  @Column(name = "comment_count" )
	private Long commentCount;

	@ApiModelProperty(value = "图片地址", position = 9)
  @Column(name = "pic" )
	private String pic;

  @Column(name = "text_raw" )
	private String textRaw;

  @Column(name = "created_at_raw" )
	private String createdAtRaw;


}
