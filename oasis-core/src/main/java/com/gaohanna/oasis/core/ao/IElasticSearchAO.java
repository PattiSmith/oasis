package com.gaohanna.oasis.core.ao;

import com.gaohanna.oasis.common.entity.BizResult;
import com.gaohanna.oasis.common.entity.PageResult;
import com.gaohanna.oasis.common.form.QueryPageForm;
import com.gaohanna.oasis.common.vo.TmsWorkbenchVO;

/**
 * something
 *
 * @author keben
 * @date 2017/12/15
 */
public interface IElasticSearchAO {
    BizResult<PageResult<TmsWorkbenchVO>> queryList(QueryPageForm form);
}
