package com.gaohanna.oasis.common.vo;

import lombok.Data;

/**
 * something
 *
 * @author keben
 * @date 2017/12/15
 */
@Data
public class TmsWorkbenchVO {
    private Long id;
    private String content;
    private Integer tag_type;
    private Integer read_status;
    private Integer dispose_status;
    private String gmt_create;
    private Long transport_order_id;
    private Integer source_type;
    private Integer status;
}
