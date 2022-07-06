--------------------------------------------------------
--  File created - Wednesday-July-06-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_CATEGORY_NO
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_CATEGORY_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
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

   CREATE SEQUENCE  "ADMIN"."SEQ_USERS_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table BLOG
--------------------------------------------------------

  CREATE TABLE "ADMIN"."BLOG" 
   (	"ID" VARCHAR2(50 BYTE) COLLATE "USING_NLS_COMP", 
	"BLOGTITLE" VARCHAR2(200 BYTE) COLLATE "USING_NLS_COMP", 
	"LOGOFILE" VARCHAR2(200 BYTE) COLLATE "USING_NLS_COMP"
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
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
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
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
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 COLUMN STORE COMPRESS FOR QUERY HIGH ROW LEVEL LOCKING LOGGING
  TABLESPACE "DATA" ;
REM INSERTING into ADMIN.BLOG
SET DEFINE OFF;
REM INSERTING into ADMIN.CATEGORY
SET DEFINE OFF;
REM INSERTING into ADMIN.COMMENTS
SET DEFINE OFF;
REM INSERTING into ADMIN.POST
SET DEFINE OFF;
REM INSERTING into ADMIN.USERS
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."USERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("JOINDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" ADD PRIMARY KEY ("USERNO")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 
  TABLESPACE "DATA"  ENABLE;
  ALTER TABLE "ADMIN"."USERS" ADD UNIQUE ("ID")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 
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
--  Constraints for Table COMMENTS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."COMMENTS" MODIFY ("CMTCONTENT" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."COMMENTS" MODIFY ("REGDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."COMMENTS" ADD PRIMARY KEY ("CMTNO")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BLOG
--------------------------------------------------------

  ALTER TABLE "ADMIN"."BLOG" MODIFY ("BLOGTITLE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."BLOG" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."CATEGORY" MODIFY ("CATENAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CATEGORY" MODIFY ("REGDATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CATEGORY" ADD PRIMARY KEY ("CATENO")
  USING INDEX PCTFREE 10 INITRANS 20 MAXTRANS 255 
  TABLESPACE "DATA"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BLOG
--------------------------------------------------------

  ALTER TABLE "ADMIN"."BLOG" ADD CONSTRAINT "BLOG_FK" FOREIGN KEY ("ID")
	  REFERENCES "ADMIN"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."CATEGORY" ADD CONSTRAINT "CATEGROY_FK" FOREIGN KEY ("ID")
	  REFERENCES "ADMIN"."BLOG" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COMMENTS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."COMMENTS" ADD CONSTRAINT "COMMENTS_FK" FOREIGN KEY ("USERNO")
	  REFERENCES "ADMIN"."USERS" ("USERNO") ENABLE;
  ALTER TABLE "ADMIN"."COMMENTS" ADD CONSTRAINT "COMMENT_FK" FOREIGN KEY ("POSTNO")
	  REFERENCES "ADMIN"."POST" ("POSTNO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table POST
--------------------------------------------------------

  ALTER TABLE "ADMIN"."POST" ADD CONSTRAINT "POST_FK" FOREIGN KEY ("CATENO")
	  REFERENCES "ADMIN"."CATEGORY" ("CATENO") ENABLE;
