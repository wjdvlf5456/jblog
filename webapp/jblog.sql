--------------------------------------------------------
--  File created - Monday-July-11-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_CATEGORY_NO
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_CATEGORY_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 3 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_COMMENTS_NO
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_COMMENTS_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_POST_NO
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_POST_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_USERS_NO
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_USERS_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 3 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table BLOG
--------------------------------------------------------

  CREATE TABLE "ADMIN"."BLOG" 
   (	"ID" VARCHAR2(50 BYTE) COLLATE "USING_NLS_COMP", 
	"BLOGTITLE" VARCHAR2(200 BYTE) COLLATE "USING_NLS_COMP", 
	"LOGOFILE" VARCHAR2(200 BYTE) COLLATE "USING_NLS_COMP"
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATA" ;
--------------------------------------------------------
--  DDL for Table CATEGORY
--------------------------------------------------------

  CREATE TABLE "ADMIN"."CATEGORY" 
   (	"CATENO" NUMBER, 
	"ID" VARCHAR2(50 BYTE) COLLATE "USING_NLS_COMP", 
	"CATENAME" VARCHAR2(200 BYTE) COLLATE "USING_NLS_COMP", 
	"DESCRIPTION" VARCHAR2(500 BYTE) COLLATE "USING_NLS_COMP", 
	"REGDATE" DATE
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATA" ;
--------------------------------------------------------
--  DDL for Table COMMENTS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."COMMENTS" 
   (	"CMTNO" NUMBER, 
	"POSTNO" NUMBER, 
	"USERNO" NUMBER, 
	"CMTCONTENT" VARCHAR2(1000 BYTE) COLLATE "USING_NLS_COMP", 
	"REGDATE" DATE
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
  TABLESPACE "DATA" ;
--------------------------------------------------------
--  DDL for Table POST
--------------------------------------------------------

  CREATE TABLE "ADMIN"."POST" 
   (	"POSTNO" NUMBER, 
	"CATENO" NUMBER, 
	"POSTTITLE" VARCHAR2(300 BYTE) COLLATE "USING_NLS_COMP", 
	"POSTCONTENT" VARCHAR2(4000 BYTE) COLLATE "USING_NLS_COMP", 
	"REGDATE" DATE
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
  TABLESPACE "DATA" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."USERS" 
   (	"USERNO" NUMBER, 
	"ID" VARCHAR2(50 BYTE) COLLATE "USING_NLS_COMP", 
	"USERNAME" VARCHAR2(50 BYTE) COLLATE "USING_NLS_COMP", 
	"PASSWORD" VARCHAR2(50 BYTE) COLLATE "USING_NLS_COMP", 
	"JOINDATE" DATE
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATA" ;
REM INSERTING into ADMIN.BLOG
SET DEFINE OFF;
Insert into ADMIN.BLOG (ID,BLOGTITLE,LOGOFILE) values ('wotjr2345','유재석님의 블로그입니다.','165751683969004940e37-2873-41a0-af39-e6bc23b2e7fb.jpg');
Insert into ADMIN.BLOG (ID,BLOGTITLE,LOGOFILE) values ('tjsgml5555','이선희님의 블로그입니다.',null);
REM INSERTING into ADMIN.CATEGORY
SET DEFINE OFF;
Insert into ADMIN.CATEGORY (CATENO,ID,CATENAME,DESCRIPTION,REGDATE) values (1,'wotjr2345','미분류','기타내용 작성 요',to_date('11-JUL-22','DD-MON-RR'));
Insert into ADMIN.CATEGORY (CATENO,ID,CATENAME,DESCRIPTION,REGDATE) values (2,'tjsgml5555','미분류','기타내용 작성 요',to_date('11-JUL-22','DD-MON-RR'));
REM INSERTING into ADMIN.COMMENTS
SET DEFINE OFF;
REM INSERTING into ADMIN.POST
SET DEFINE OFF;
REM INSERTING into ADMIN.USERS
SET DEFINE OFF;
Insert into ADMIN.USERS (USERNO,ID,USERNAME,PASSWORD,JOINDATE) values (1,'wotjr2345','유재석','2345',to_date('11-JUL-22','DD-MON-RR'));
Insert into ADMIN.USERS (USERNO,ID,USERNAME,PASSWORD,JOINDATE) values (2,'tjsgml5555','이선희','5555',to_date('11-JUL-22','DD-MON-RR'));
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."USERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("JOINDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" ADD PRIMARY KEY ("USERNO")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATA"  ENABLE;
  ALTER TABLE "ADMIN"."USERS" ADD UNIQUE ("ID")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table POST
--------------------------------------------------------

  ALTER TABLE "ADMIN"."POST" MODIFY ("POSTTITLE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."POST" MODIFY ("REGDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."POST" ADD PRIMARY KEY ("POSTNO")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BLOG
--------------------------------------------------------

  ALTER TABLE "ADMIN"."BLOG" MODIFY ("BLOGTITLE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."BLOG" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table COMMENTS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."COMMENTS" MODIFY ("CMTCONTENT" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."COMMENTS" MODIFY ("REGDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."COMMENTS" ADD PRIMARY KEY ("CMTNO")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."CATEGORY" MODIFY ("CATENAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CATEGORY" MODIFY ("REGDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CATEGORY" ADD PRIMARY KEY ("CATENO")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BLOG
--------------------------------------------------------

  ALTER TABLE "ADMIN"."BLOG" ADD CONSTRAINT "BLOG_FK" FOREIGN KEY ("ID")
	  REFERENCES "ADMIN"."USERS" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."CATEGORY" ADD CONSTRAINT "CATEGROY_FK" FOREIGN KEY ("ID")
	  REFERENCES "ADMIN"."BLOG" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COMMENTS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."COMMENTS" ADD CONSTRAINT "COMMENTS_FK" FOREIGN KEY ("USERNO")
	  REFERENCES "ADMIN"."USERS" ("USERNO") ON DELETE CASCADE ENABLE;
  ALTER TABLE "ADMIN"."COMMENTS" ADD CONSTRAINT "COMMENT_FK" FOREIGN KEY ("POSTNO")
	  REFERENCES "ADMIN"."POST" ("POSTNO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table POST
--------------------------------------------------------

  ALTER TABLE "ADMIN"."POST" ADD CONSTRAINT "POST_FK" FOREIGN KEY ("CATENO")
	  REFERENCES "ADMIN"."CATEGORY" ("CATENO") ON DELETE CASCADE ENABLE;
