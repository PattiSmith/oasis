package com.gaohanna.oasis.ao;

import com.gaohanna.oasis.entity.BizResult;
import com.gaohanna.oasis.entity.PageResult;
import com.gaohanna.oasis.form.QueryPageForm;
import com.gaohanna.oasis.vo.TmsWorkbenchVO;

/**
 * something
 *
 * @author keben
 * @date 2017/12/15
 */
public interface IElasticSearchAO {
    BizResult<PageResult<TmsWorkbenchVO>> queryList(QueryPageForm form);
}
