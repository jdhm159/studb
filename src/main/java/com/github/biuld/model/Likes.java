package com.github.biuld.model;


import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;

@Data
public class Likes {

	@ApiModelProperty(value = "id", position = 0)
	@Id
	private Integer id;

	@ApiModelProperty(value = "点赞者的联合唯一标识（sha-256(user-agent+ip)）", position = 1)
	private String uid;

	@ApiModelProperty(value = "创建时间", position = 2)
	private java.time.LocalDateTime createdAt;


}
