package com.realguo.web.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("depot_prop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepotPropEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId
	private Long id;

	/**
	 * 仓库ID
	 */
	private Long depotId;

	/**
	 * 道具ID
	 */
	private Long propId;
}