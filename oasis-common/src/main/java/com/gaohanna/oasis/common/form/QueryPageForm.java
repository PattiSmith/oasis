package com.gaohanna.oasis.common.form;

import lombok.Data;

/**
 * something
 *
 * @author keben
 * @date 2017/12/15
 */
@Data
public class QueryPageForm {
    private Integer pageNo;
    private Integer pageSize;
    private String indexName;
    private String docType;
    private Integer tagType;
}
