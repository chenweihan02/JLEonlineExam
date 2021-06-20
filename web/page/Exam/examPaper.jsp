<%--
  Created by IntelliJ IDEA.
  User: xiaochen
  Date: 2021/6/17
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>组卷</title>
    <style>
        * {margin: 0; padding: 0;}
        html, body
        {width: 100%;height: 100%;overflow:auto;font-size:12px;margin:0;padding:0; font-family:"微软雅黑";background:#fff; text-align:center;
        }
        ul,li{ list-style:none;}
        a{ text-decoration:none; color:#666;}
        a:hover{text-decoration:none;}
        .hover{background:#0f6c8d;}

        i{font-style:normal;}


        #active{font-size:12px; color:#289cd5; font-weight:bold;}
        .course_main{width:100%; height:100%;}

        /*top start*/
        .top{width:100%; height:90px; background:#fff; color:#000;}
        .top_nr{width:1200px; margin:0 auto;}
        .top_left{height:90px; float:left;}
        .top_left i{width:180px; height:90px; display:block; float:left;}
        .top_left h1{line-height:100px; display:block; float:left; font-size:28px; }

        .top_right{height:90px; float:right; line-height:90px; padding-right:10px;}
        .top_right a{padding:0 10px; color:#000; font-size:14px; display:block; float:left;}
        .top_right a span{padding-right:5px; display:block; float:left;}
        .top_right a i{color:#f00; padding: 0 5px; display:block; float:left;}
        .top_right a b{display:block; float:left;}
        .top_right a img{margin-top:30px; display:block; float:left;}
        /*top end*/
        /*nav start*/
        .nav{width:100%; height:50px; background:#389fc3; margin-top:15px;}
        .nav_nr{width:1200px; height:50px; line-height:50px; margin:0 auto;  font-size:14px;}
        .nav_nr ul{display:block; margin:0;}
        .nav_nr ul li{height:50px;  display:block; float:left;}
        .nav_nr ul li a{ color:#fff; display:block; height:50px; float:left; padding:0 20px;}
        .nav_nr ul li a:hover{text-decoration:none;}
        .nav_nr i{color:#fff; display:block; float:left;}

        /*分页 start*/
        .fy{width:100%; height:50px; margin-left:15px; margin-top: 10px; float:left;}
        /*分页 end*/
        /*百分比进度 start*/
        .easyPieChart {position: relative;text-align: center;}
        .easyPieChart canvas { position: absolute;top: 0;left: 0;}
        /*百分比进度 end*/
        /*nav end*/
        .foot{width:100%; height:50px; clear:both;}

        .test_content_title font{width:80px; height:45px;  display:block; float:right; text-align:center; }
        .test_content_title font input{background:#389fc3; border:none; display:block; width:80px; height:45px; cursor:pointer; color:#fff; font-size:16px; font-weight:bold;}
        .test_content_title font input:active{background:#79aef0;}

        /*nr start*/
        .test_main{width:1200px;  margin:15px auto 0;}
        .nr_left{width:900px; height:100%; float:left;}

        .test{ width:100%;  border:1px solid #e4e4e4; text-align:left; float:left;}
        .test_title{width:900px; height:45px; line-height:45px; background-color:#f7f7f7;position:fixed; bottom:0; z-index:1000;}
        .test_title p{padding:0 20px; display:block; float:left;}
        .test_time{color:#f00; line-height:45px;}
        .test_time i{font-size:20px; height:45px; line-height:40px; display:block; float:left}
        .test_time b{font-size:16px; height:45px; display:block; float:left; margin-left:10px;}
        .test_dtk {line-height:45px;}
        .test_dtk i{font-size:22px; height:45px; line-height:45px; display:block; float:left; color:#389fc3;}
        .test_dtk span{font-size:14px; height:45px; display:block; float:left; margin-left:10px;}
        .test_title font{width:80px; height:45px;  display:block; float:right; text-align:center; }
        .test_title font input{background:#389fc3; border:none; display:block; width:80px; height:45px; cursor:pointer; color:#fff; font-size:16px; font-weight:bold;}
        .test_title font input:active{background:#79aef0;}
        .test_time{color:#f00; line-height:45px;}
        .test_time i{font-size:20px; height:45px; line-height:40px; display:block; float:left}
        .test_time b{font-size:16px; height:45px; display:block; float:left; margin-left:10px;}
        .test_dtk {line-height:45px;}
        .test_dtk i{font-size:22px; height:45px; line-height:45px; display:block; float:left; color:#389fc3;}
        .test_dtk span{font-size:14px; height:45px; display:block; float:left; margin-left:10px;}
        .test_content{width:100%; height:auto; margin-top:15px;}
        .test_content_title{width:100%; height:50px; line-height:50px; background:#f7f7f7; text-align:center;}
        .test_content_title h2{padding:0 30px; font-size:16px; font-weight:normal; display:block; float:left}
        .test_content_title p{padding:0 10px; height:40px; line-height:40px; background:#389fc3; color:#fff; border-radius:30px; display:block; float:left; margin-top:5px;}

        .test_content_nr{width:100%; border-top:3px solid #efefef;}
        .test_content_nr>ul>li{width:100%;  border-bottom:5px solid #efefef; padding-top:10px;}
        .test_content_nr_tt{width:85%; height:auto; line-height:32px; margin:0 auto; border-bottom:1px solid #e4e4e4;}
        .test_content_nr_tt i{width:25px; height:25px; line-height:25px; text-align:center; display:block; float:left; background:#5d9cec; border-radius:50%; margin-left:-50px; color:#fff; margin-top:8px; font-size:16px;}
        .test_content_nr_tt span{padding:0 8px;}
        .test_content_nr_tt font{font-size:14px}
        .test_content_nr_tt b{display:block; float:right; margin-right:-50px; color:#f48c27; font-size:20px;}

        .test_content_nr_main{width:85%; margin:0 auto; padding:10px 0;height:auto;}

        .option{line-height:32px; display:block; background:#fff;color:#666;}
        .option:hover{background:#e4e4e4;}
        .option input{width:20px; height:20px; display:block; float:left; margin:10px 10px 0 0;}
        .option label{height:auto;display:block;}

        .test_more_nr_main{width:85%; margin:0 auto; padding:10px 0;}
        .multiple{width:100%; height:40px; line-height:40px; display:block; background:#fff; margin-bottom:3px;}
        .multiple:hover{background:#e4e4e4;}
        .multiple dd input{width:20px; height:20px; display:block; float:left; margin:10px 10px 0 0;}
        .multiple dd label{width:725px; height:40px; display:block; float:left;}
        .test_click{background:#7aaff3; }
        .test_click a{color:#fff;}
        /*nr_right start*/
        .nr_right{width:280px; height:100%; float:right;}
        .nr_rt_main{width:100%; height:auto;}

        .rt_nr1{width:280px; position:fixed; top:15px; z-index:1000;}
        .rt_nr1_title{width:280px; height:45px; line-height:45px; background:#f3f3f3;}
        .rt_nr1_title h1{width:130px; height:45px; background:#389fc3; text-align:center; font-size:14px; display:block; float:left; color:#fff;}
        .rt_nr1_title h1 i{padding:0 5px; font-size:14px; font-weight:normal;}
        .rt_nr1_title p{width:141px; height:43px;  padding-right:8px; border:1px solid #e4e4e4; border-left:0; display:block; float:right;}
        .rt_nr1_title p i{margin-left:10px;}

        .rt_content{width:278px; height:100%; border:1px solid #e4e4e4; border-top:0;}
        .rt_content_tt{width:95%; height:40px; line-height:40px; margin:0 auto; border-bottom:1px solid #e4e4e4;}
        .rt_content_tt h2{width:150px; font-size:14px; display:inline-block;}
        .rt_content_tt p{width:100px; display:inline-block;}
        .answerSheet ul{padding:10px; text-align:left;}
        .answerSheet li{ display:inline-block;margin-bottom:5px; height:30px; width:30px; line-height:30px; text-align:center; border:1px solid #e4e4e4;}
        .answerSheet li a{display:block;}
        .answerSheet li:hover{color:#389fc3;border-color: #389fc3;}

        .rt_more{width:278px; height:100%; border:1px solid #e4e4e4; border-top:0;}
        .rt_more_tt{width:95%; height:40px; line-height:40px; margin:0 auto; border-bottom:1px solid #e4e4e4;}
        .rt_more_tt h2{width:150px; font-size:14px; display:inline-block;}
        .rt_more_tt p{width:100px; display:inline-block;}
        .rt_more_nr ul{padding:10px; text-align:left;}
        .rt_more_nr ul li{ display:inline-block; margin:5px; height:30px; width:30px; line-height:30px; text-align:center; border:1px solid #e4e4e4;}


        /*nr_right end*/
        /*nr end*/

        .iconfont {
            font-family:"iconfont" !important;
            font-size:16px;
            font-style:normal;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .icon-gouwuche:before { content: "\e600"; }

        .icon-mima:before { content: "\e65e"; }

        .icon-shijian:before { content: "\e6fb"; }

        .icon-xiaosanjiaoxing02:before { content: "\e631"; }

        .icon-sousuo:before { content: "\e6d7"; }

        .icon-jinlingyingcaiwangtubiao08:before { content: "\e6a1"; }

        .icon-renminbi:before { content: "\e664"; }

        .icon-gouxuan:before { content: "\e739"; }

        .icon-xiangshang:before { content: "\e635"; }

        .icon-xiangxia:before { content: "\e636"; }

        .icon-shuangjiantouxiangzuo:before { content: "\e69d"; }

        .icon-yonghuming:before { content: "\e66b"; }

        .icon-2daochu01:before { content: "\e601"; }

        .icon-datiqia:before { content: "\e692"; }

        .icon-wujiaoxing2:before { content: "\e881"; }

        .icon-peixun:before { content: "\e67c"; }

        .icon-cha:before { content: "\e605"; }

        .icon-piliangshanchu:before { content: "\e618"; }

        .icon-Create_member:before { content: "\e603"; }

        .icon-daoru8:before { content: "\e602"; }

        .icon-xiaosanjiaoxing01:before { content: "\e73d"; }

        .icon-youjiantou-copy:before { content: "\e73e"; }
        #score {
            width: 40px;
            height: 30px;
            font-size: 20px;
            border: 1px solid #fff;
            outline: none;
            line-height: 40px;
            background-color: rgb(56, 159, 195);
            vertical-align: middle;
            color: #fff;
            padding-left: 5px;
        }
        .option {
            line-height: 40px;
            display: block;
            background: #fff;
            color: #666;
            height: 40px;
        }
        .test_content_nr .q_input {
            outline: none;
            border: 1px solid #000;
            padding-left: 5px;
            display: inline-block;
            width: 300px;
            height: 30px;
            float: none;
            margin-top: 0;
            margin-left: 10px                                                                                                                           ;
        }
    </style>
</head>
<body>
<div class="main">
    <!--nr start-->
    <div class="test_main">
        <div class="nr_left">
            <div class="test">
                <form action="exam?method=judge&examId=${examId}&examPaperId=${examPaperId}" method="post">
                    <div class="test_title">
                        <p class="test_time">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1">00:01</b>
                        </p>
                        <font><input type="submit" name="test_jiaojuan" value="交卷"></font>
                    </div>
                    <div class="test_content">
                        <div class="test_content_title">
                            <h2>单选题</h2>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul>
                        <c:forEach items="${questionList}" var="question" varStatus="idxQuestion">
                            <li id="qu_${idxQuestion.index}">
                                <div class="test_content_nr_tt">
                                    <span>(${question.score}分)</span>
                                    <font>${question.title}</font>
                                </div>
                                <%--radio 的name绑定value--%>
                                <div class="test_content_nr_main">
                                    <ul>
                                        <li class="option">
                                            <input type="radio" class="radioOrCheck" name="answer${question.id}" id="0_answer_${idxQuestion.index}_option_1" value="A"/>
                                            <label for="0_answer_${idxQuestion.index}_option_1">
                                                A.
                                                <p class="ue" style="display: inline;">${question.attrA}</p>
                                            </label>
                                        </li>
                                        <li class="option">
                                            <input type="radio" class="radioOrCheck" name="answer${question.id}" id="0_answer_${idxQuestion.index}_option_2" value="B"/>
                                            <label for="0_answer_${idxQuestion.index}_option_2">
                                                B.
                                                <p class="ue" style="display: inline;">${question.attrB}</p>
                                            </label>
                                        </li>
                                        <li class="option">
                                            <input type="radio" class="radioOrCheck" name="answer${question.id}" id="0_answer_${idxQuestion.index}_option_3" value="C"/>
                                            <label for="0_answer_${idxQuestion.index}_option_3">
                                                C.
                                                <p class="ue" style="display: inline;">${question.attrC}</p>
                                            </label>
                                        </li>
                                        <li class="option">
                                            <input type="radio" class="radioOrCheck" name="answer${question.id}" id="0_answer_${idxQuestion.index}_option_4" value="D"/>
                                            <label for="0_answer_${idxQuestion.index}_option_4">
                                                D.
                                                <p class="ue" style="display: inline;">${question.attrD}</p>
                                            </label>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
        <div class="nr_right">
            <div class="nr_rt_main">
                <div class="rt_nr1">
                    <div class="rt_nr1_title">
                        <h1>
                            <i class="icon iconfont">&#xe692;</i>答题卡
                        </h1>
                        <p class="test_time">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1">00:02</b>
                        </p>
                    </div>

                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <h2>单选题</h2>
                            <p>
                                <span>共</span><i class="content_lit">2</i><span>题</span>
                            </p>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul>
                                <c:forEach items="${questionList}" var="question" varStatus="idxQuestion">
                                    <li><a href="#qu_${idxQuestion.index}">${idxQuestion.index + 1}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>