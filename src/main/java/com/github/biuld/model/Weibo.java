package com.github.biuld.model;


import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;

@Data
public class Weibo {

	/**
	 * 涓婚敭id
	 */
	@ApiModelProperty(value = "涓婚敭id", position = 0)
	@Id
	private Integer id;

	@ApiModelProperty(value = "id", position = 1)
	private String mid;

	@ApiModelProperty(value = "id", position = 2)
	private String bid;

	@ApiModelProperty(value = "内容", position = 3)
	private String text;

	@ApiModelProperty(value = "存储时间", position = 4)
	private java.time.LocalDateTime storedAt;

	@ApiModelProperty(value = "创建时间", position = 5)
	private java.time.LocalDateTime createdAt;

	@ApiModelProperty(value = "点赞次数", position = 6)
	private Long likesCount;

	@ApiModelProperty(value = "转发次数", position = 7)
	private Long repostsCount;

	@ApiModelProperty(value = "评论次数", position = 8)
	private Long commentsCount;

	@ApiModelProperty(value = "图片地址", position = 9)
	private String pic;


}
