package com.yihaomen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AmsOperatorOriginalityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public AmsOperatorOriginalityCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdIsNull() {
            addCriterion("originality_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdIsNotNull() {
            addCriterion("originality_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdEqualTo(String value) {
            addCriterion("originality_id =", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdNotEqualTo(String value) {
            addCriterion("originality_id <>", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdGreaterThan(String value) {
            addCriterion("originality_id >", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdGreaterThanOrEqualTo(String value) {
            addCriterion("originality_id >=", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdLessThan(String value) {
            addCriterion("originality_id <", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdLessThanOrEqualTo(String value) {
            addCriterion("originality_id <=", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdLike(String value) {
            addCriterion("originality_id like", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdNotLike(String value) {
            addCriterion("originality_id not like", value, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdIn(List<String> values) {
            addCriterion("originality_id in", values, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdNotIn(List<String> values) {
            addCriterion("originality_id not in", values, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdBetween(String value1, String value2) {
            addCriterion("originality_id between", value1, value2, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityIdNotBetween(String value1, String value2) {
            addCriterion("originality_id not between", value1, value2, "originalityId");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescIsNull() {
            addCriterion("originality_desc is null");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescIsNotNull() {
            addCriterion("originality_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescEqualTo(String value) {
            addCriterion("originality_desc =", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescNotEqualTo(String value) {
            addCriterion("originality_desc <>", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescGreaterThan(String value) {
            addCriterion("originality_desc >", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescGreaterThanOrEqualTo(String value) {
            addCriterion("originality_desc >=", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescLessThan(String value) {
            addCriterion("originality_desc <", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescLessThanOrEqualTo(String value) {
            addCriterion("originality_desc <=", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescLike(String value) {
            addCriterion("originality_desc like", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescNotLike(String value) {
            addCriterion("originality_desc not like", value, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescIn(List<String> values) {
            addCriterion("originality_desc in", values, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescNotIn(List<String> values) {
            addCriterion("originality_desc not in", values, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescBetween(String value1, String value2) {
            addCriterion("originality_desc between", value1, value2, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andOriginalityDescNotBetween(String value1, String value2) {
            addCriterion("originality_desc not between", value1, value2, "originalityDesc");
            return (Criteria) this;
        }

        public Criteria andPaintFlagIsNull() {
            addCriterion("paint_flag is null");
            return (Criteria) this;
        }

        public Criteria andPaintFlagIsNotNull() {
            addCriterion("paint_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPaintFlagEqualTo(Boolean value) {
            addCriterion("paint_flag =", value, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagNotEqualTo(Boolean value) {
            addCriterion("paint_flag <>", value, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagGreaterThan(Boolean value) {
            addCriterion("paint_flag >", value, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("paint_flag >=", value, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagLessThan(Boolean value) {
            addCriterion("paint_flag <", value, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("paint_flag <=", value, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagIn(List<Boolean> values) {
            addCriterion("paint_flag in", values, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagNotIn(List<Boolean> values) {
            addCriterion("paint_flag not in", values, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("paint_flag between", value1, value2, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andPaintFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("paint_flag not between", value1, value2, "paintFlag");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andIsDownIsNull() {
            addCriterion("is_down is null");
            return (Criteria) this;
        }

        public Criteria andIsDownIsNotNull() {
            addCriterion("is_down is not null");
            return (Criteria) this;
        }

        public Criteria andIsDownEqualTo(Boolean value) {
            addCriterion("is_down =", value, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownNotEqualTo(Boolean value) {
            addCriterion("is_down <>", value, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownGreaterThan(Boolean value) {
            addCriterion("is_down >", value, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_down >=", value, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownLessThan(Boolean value) {
            addCriterion("is_down <", value, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownLessThanOrEqualTo(Boolean value) {
            addCriterion("is_down <=", value, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownIn(List<Boolean> values) {
            addCriterion("is_down in", values, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownNotIn(List<Boolean> values) {
            addCriterion("is_down not in", values, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownBetween(Boolean value1, Boolean value2) {
            addCriterion("is_down between", value1, value2, "isDown");
            return (Criteria) this;
        }

        public Criteria andIsDownNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_down not between", value1, value2, "isDown");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNull() {
            addCriterion("update_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNotNull() {
            addCriterion("update_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameEqualTo(String value) {
            addCriterion("update_name =", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotEqualTo(String value) {
            addCriterion("update_name <>", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThan(String value) {
            addCriterion("update_name >", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_name >=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThan(String value) {
            addCriterion("update_name <", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("update_name <=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLike(String value) {
            addCriterion("update_name like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotLike(String value) {
            addCriterion("update_name not like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIn(List<String> values) {
            addCriterion("update_name in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotIn(List<String> values) {
            addCriterion("update_name not in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameBetween(String value1, String value2) {
            addCriterion("update_name between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotBetween(String value1, String value2) {
            addCriterion("update_name not between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("update_datetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("update_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("update_datetime =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("update_datetime <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("update_datetime >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_datetime >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("update_datetime <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("update_datetime <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("update_datetime in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("update_datetime not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("update_datetime between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("update_datetime not between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}