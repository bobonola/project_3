/* 회원 테이블 */
DROP TABLE USERS;

CREATE TABLE USERS (
    EMAIL       VARCHAR2(50)    PRIMARY KEY,
    USER_NO     NUMBER(5)       NOT NULL,
    PASSWORD    VARCHAR2(50)    NOT NULL,
    NAME        VARCHAR2(20)    NOT NULL,
    PHONE_NO    VARCHAR2(11)    NOT NULL,
    BIRTH       VARCHAR2(10)     NOT NULL,
    ADMIN_CODE  NUMBER(1)       NOT NULL,
    ADDRESS1    VARCHAR2(200)   NOT NULL,
    ADDRESS2    VARCHAR2(200)   NOT NULL,
    ZIPCODE     VARCHAR2(5)     NOT NULL
);

DROP SEQUENCE SEQ_USERS_NO;

CREATE SEQUENCE SEQ_USERS_NO
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99999
NOCYCLE;

COMMENT ON COLUMN USERS.EMAIL           IS '이메일';
COMMENT ON COLUMN USERS.USER_NO         IS '회원번호';
COMMENT ON COLUMN USERS.PASSWORD        IS '비밀번호';
COMMENT ON COLUMN USERS.NAME            IS '이름';
COMMENT ON COLUMN USERS.PHONE_NO        IS '휴대폰번호';
COMMENT ON COLUMN USERS.BIRTH           IS '생년월일';
COMMENT ON COLUMN USERS.ADMIN_CODE      IS '회원및관리자코드';
COMMENT ON COLUMN USERS.ADDRESS1        IS '주소';
COMMENT ON COLUMN USERS.ADDRESS2        IS '상세주소';
COMMENT ON COLUMN USERS.ZIPCODE         IS '우편번호';

/* 상품 테이블 */
DROP TABLE PRODUCT;

CREATE TABLE PRODUCT (
    PRODUCT_NO          NUMBER(5)       PRIMARY KEY,
    ST_NO               VARCHAR2(20)    NOT NULL,
    PRODUCT_NAME        VARCHAR2(100)   NOT NULL,
    PRODUCT_DATE        DATE            NOT NULL,
    PRODUCT_MAIN_IMAGE  VARCHAR2(2000)  NOT NULL,
    PRODUCT_IMAGE1      VARCHAR2(2000)  NULL,
    PRODUCT_IMAGE2      VARCHAR2(2000)  NULL,
    PRODUCT_IMAGE3      VARCHAR2(2000)  NULL,
    PRODUCT_IMAGE4      VARCHAR2(2000)  NULL,
    PRODUCT_IMAGE5      VARCHAR2(2000)  NULL,
    PRODUCT_PRICE       NUMBER(10)      NOT NULL,
    PRODUCT_DESCRIPTION VARCHAR2(2000)  NULL
);



DROP SEQUENCE SEQ_PRODUCT_NO;

CREATE SEQUENCE SEQ_PRODUCT_NO
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99999
NOCYCLE;

COMMENT ON COLUMN PRODUCT.PRODUCT_NO            IS '상품번호';
COMMENT ON COLUMN PRODUCT.ST_NO                 IS '스타일번호';
COMMENT ON COLUMN PRODUCT.PRODUCT_NAME          IS '상품명';
COMMENT ON COLUMN PRODUCT.PRODUCT_DATE          IS '상품등록일자';
COMMENT ON COLUMN PRODUCT.PRODUCT_MAIN_IMAGE    IS '상품메인이미지';
COMMENT ON COLUMN PRODUCT.PRODUCT_IMAGE1        IS '이미지1';
COMMENT ON COLUMN PRODUCT.PRODUCT_IMAGE2        IS '이미지2';
COMMENT ON COLUMN PRODUCT.PRODUCT_IMAGE3        IS '이미지3';
COMMENT ON COLUMN PRODUCT.PRODUCT_IMAGE4        IS '이미지4';
COMMENT ON COLUMN PRODUCT.PRODUCT_IMAGE5        IS '이미지5';
COMMENT ON COLUMN PRODUCT.PRODUCT_PRICE         IS '가격';
COMMENT ON COLUMN PRODUCT.PRODUCT_DESCRIPTION   IS '상품설명';


/* 상품상세 테이블 */
DROP TABLE PRODUCT_INVENTORY;

CREATE TABLE PRODUCT_INVENTORY (
    PRODUCT_NO          NUMBER(5)       PRIMARY KEY,
    PRODUCT_TOTAL_STOCK NUMBER(4)       NOT NULL,
    PRODUCT_SIZE_230    NUMBER(3)       NOT NULL,
    PRODUCT_SIZE_240    NUMBER(3)       NOT NULL,
    PRODUCT_SIZE_250    NUMBER(3)       NOT NULL,
    PRODUCT_SIZE_260    NUMBER(3)       NOT NULL,
    PRODUCT_SIZE_270    NUMBER(3)       NOT NULL,
    PRODUCT_SIZE_280    NUMBER(3)       NOT NULL,
    PRODUCT_SIZE_290    NUMBER(3)       NOT NULL,
    PRODUCT_SIZE_300    NUMBER(3)       NOT NULL,
    CONSTRAINT FK_PRODUCT_INVENTORY FOREIGN KEY(PRODUCT_NO)
    REFERENCES PRODUCT(PRODUCT_NO)
);


COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_NO           IS '상품번호';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_TOTAL_STOCK  IS '상품재고합계';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_230     IS '사이즈230재고';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_240     IS '사이즈240재고';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_250     IS '사이즈250재고';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_260     IS '사이즈260재고';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_270     IS '사이즈270재고';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_280     IS '사이즈280재고';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_290     IS '사이즈290재고';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRODUCT_SIZE_300     IS '사이즈300재고';


/* 리뷰 테이블 */
DROP TABLE REVIEW;

CREATE TABLE REVIEW (
    REVIEW_NO           NUMBER(5)       PRIMARY KEY,
    EMAIL               VARCHAR2(50)    NOT NULL,
    PRODUCT_NO          NUMBER(5)       NOT NULL,
    REVIEW_TITLE        VARCHAR2(100)   NOT NULL,
    REVIEW_CONTENT      VARCHAR2(2000)  NOT NULL,
    REVIEW_IMAGE        VARCHAR2(2000)  NULL,
    REVIEW_DATE         DATE            NOT NULL,
    REVIEW_RATINGS      NUMBER(1)       NOT NULL,
    CONSTRAINT FK_REVIEW_EMAIL FOREIGN KEY(EMAIL)
    REFERENCES USERS(EMAIL),
    CONSTRAINT FK_REVIEW_PRODUCT_NO FOREIGN KEY(PRODUCT_NO)
    REFERENCES PRODUCT(PRODUCT_NO)
);





DROP SEQUENCE SEQ_REVIEW_NO;

CREATE SEQUENCE SEQ_REVIEW_NO
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99999
NOCYCLE;

COMMENT ON COLUMN REVIEW.REVIEW_NO           IS '리뷰번호';
COMMENT ON COLUMN REVIEW.EMAIL               IS '이메일';
COMMENT ON COLUMN REVIEW.PRODUCT_NO          IS '상품번호';
COMMENT ON COLUMN REVIEW.REVIEW_TITLE        IS '리뷰제목';
COMMENT ON COLUMN REVIEW.REVIEW_CONTENT      IS '리뷰내용';
COMMENT ON COLUMN REVIEW.REVIEW_IMAGE        IS '리뷰이미지';
COMMENT ON COLUMN REVIEW.REVIEW_DATE         IS '리뷰작성일';
COMMENT ON COLUMN REVIEW.REVIEW_RATINGS      IS '리뷰평점';

/* QNA 테이블 */
DROP TABLE QNA;

CREATE TABLE QNA (
    QNA_NO              NUMBER(5)           PRIMARY KEY,
    EMAIL               VARCHAR2(50)        NOT NULL,
    QNA_NAME            VARCHAR2(20)        NOT NULL,
    QNA_TITLE           VARCHAR2(100)       NOT NULL,
    QNA_CONTENT         VARCHAR2(2000)      NOT NULL,
    QNA_DATE            DATE                NOT NULL,
    QNA_HIT             NUMBER(5) DEFAULT 0 NOT NULL,
    QNA_GROUP           NUMBER(5)           NOT NULL,
    QNA_STEP            NUMBER(5)           NOT NULL,
    QNA_INDENT          NUMBER(5)           NOT NULL,
    QNA_SECRET_CODE     NUMBER(1)           NOT NULL,
    QNA_ORIGINAL_NAME   VARCHAR2(20)        NOT NULL,  
    CONSTRAINT FK_QNA FOREIGN KEY(EMAIL)
    REFERENCES USERS(EMAIL)
);

DROP SEQUENCE SEQ_QNA_NO;

CREATE SEQUENCE SEQ_QNA_NO
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99999
NOCYCLE;

COMMENT ON COLUMN QNA.QNA_NO              IS '질문번호';
COMMENT ON COLUMN QNA.EMAIL               IS '이메일';
COMMENT ON COLUMN QNA.QNA_NAME            IS '질문작성자';
COMMENT ON COLUMN QNA.QNA_TITLE           IS '질문제목';
COMMENT ON COLUMN QNA.QNA_CONTENT         IS '질문내용';
COMMENT ON COLUMN QNA.QNA_DATE            IS '질문작성일';
COMMENT ON COLUMN QNA.QNA_HIT             IS '질문조회수';
COMMENT ON COLUMN QNA.QNA_GROUP           IS '질문답글그룹';
COMMENT ON COLUMN QNA.QNA_STEP            IS '질문답글스텝';
COMMENT ON COLUMN QNA.QNA_INDENT          IS '질문답글인덴트';
COMMENT ON COLUMN QNA.QNA_SECRET_CODE     IS '비밀글코드';
COMMENT ON COLUMN QNA.QNA_ORIGINAL_NAME   IS '원글작성자';


/* 공지사항 테이블 */
DROP TABLE NOTICE;

CREATE TABLE NOTICE (
    NOTICE_NO       NUMBER(5)           PRIMARY KEY,
    EMAIL           VARCHAR2(50)        NOT NULL,
    NOTICE_TITLE    VARCHAR2(100)       NOT NULL,
    NOTICE_CONTENT  VARCHAR2(2000)      NOT NULL,
    NOTICE_DATE     DATE                NOT NULL,
    NOTICE_HIT      NUMBER(5) DEFAULT 0 NOT NULL,
    NOTICE_IMAGE    VARCHAR2(2000)      NULL,
    CONSTRAINT FK_NOTICE FOREIGN KEY(EMAIL)
    REFERENCES USERS(EMAIL)
);

DROP SEQUENCE SEQ_NOTICE_NO;

CREATE SEQUENCE SEQ_NOTICE_NO
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99999
NOCYCLE;

COMMENT ON COLUMN NOTICE.NOTICE_NO              IS '공지사항번호';
COMMENT ON COLUMN NOTICE.EMAIL                  IS '이메일';
COMMENT ON COLUMN NOTICE.NOTICE_TITLE           IS '공지사항제목';
COMMENT ON COLUMN NOTICE.NOTICE_CONTENT         IS '공지사항내용';
COMMENT ON COLUMN NOTICE.NOTICE_DATE            IS '공지사항작성일';
COMMENT ON COLUMN NOTICE.NOTICE_HIT             IS '공지사항조회수';
COMMENT ON COLUMN NOTICE.NOTICE_IMAGE           IS '공지사항이미지';

/* 장바구니 테이블 */
DROP TABLE CART;

CREATE TABLE CART (
    CART_NO             NUMBER(5)       PRIMARY KEY,
    EMAIL               VARCHAR2(50)    NOT NULL,
    PRODUCT_NO          NUMBER(5)       NOT NULL,
    PRODUCT_COUNT       NUMBER(5)       NOT NULL,
    PRODUCT_SIZE        NUMBER(3)       NOT NULL,
    CONSTRAINT FK_CART_EMAIL FOREIGN KEY(EMAIL)
    REFERENCES USERS(EMAIL),
    CONSTRAINT FK_CART_PRODUCT_NO FOREIGN KEY(PRODUCT_NO)
    REFERENCES PRODUCT(PRODUCT_NO)
);

DROP SEQUENCE SEQ_CART_NO;

CREATE SEQUENCE SEQ_CART_NO
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99999
NOCYCLE;

COMMENT ON COLUMN CART.CART_NO                  IS '장바구니번호';
COMMENT ON COLUMN CART.EMAIL                    IS '이메일';
COMMENT ON COLUMN CART.PRODUCT_NO               IS '상품번호';
COMMENT ON COLUMN CART.PRODUCT_COUNT            IS '상품갯수';
COMMENT ON COLUMN CART.PRODUCT_SIZE             IS '상품사이즈';



COMMIT;