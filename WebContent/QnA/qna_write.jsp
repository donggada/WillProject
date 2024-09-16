<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
     <%String id = (String)session.getAttribute("Member_id"); 
        if(id==null){
        %>
    <script type="text/javascript">
      alert("회원만 작성가능합니다.")
    window.history.back();
    </script>
        
    <% }%>

<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <link href="style.css" rel="stylesheet">
  <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">

  
    <jsp:include page="/inc/Header.jsp"></jsp:include>
</head>

<body class="loader-active">

    <!--== Preloader Area Start ==-->
    <div class="preloader">
        <div class="preloader-spinner">
            <div class="loader-content">
                <img src="assets/img/preloader.gif" alt="JSOFT">
            </div>
        </div>
    </div>
    <!--== Preloader Area End ==-->

    <jsp:include page="/inc/Header.jsp"></jsp:include>
    <!--== Header Area End ==-->

    <!--== Page Title Area Start ==-->
    <section id="page-title-area" class="section-padding overlay">
        <div class="container">
            <div class="row">
                <!-- Page Title Start -->
                <div class="col-lg-12">
                    <div class="section-title  text-center">
                        <h2>1:1 Inquiry</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p>Don't hesitate to ask me any questions!</p>
                    </div>
                </div>
                <!-- Page Title End -->
            </div>
        </div>
    </section>
    <!--== Page Title Area End ==-->

    <!--== Car List Area Start ==-->
    <div id="blog-page-content" class="section-padding">
        <div class="container">
            <div class="row">
                <!-- Single Articles Start -->
                <div class="col-lg-12">
                    <article class="single-article">
                        <div class="row">
                            <!-- Articles Thumbnail Start -->
                            <div class="col-lg-5">
                                <div class="article-thumb">
                                    <img src="assets/img/article/arti-thumb-1.jpg" alt="JSOFT">
                                       <img src="assets/img/article/arti-thumb-2.jpg" alt="JSOFT">
                                </div>
                            </div>
                            <!-- Articles Thumbnail End -->

                            <!-- Articles Content Start -->
                            <div class="col-lg-7">
                                <div class="display-table">
                                    <div class="display-table-cell">
                                        <div class="article-body">
                                            <h3><a href="#">1:1 Inquiry</a></h3>
                                            <div class="article-meta">
                                                <a href="#" class="author">By :: <span><%=id%></span></a>
                                                <a href="qnaBoardlist.bo" class="commnet">나의 문의내역 보기</a>
                                            </div>

                                            <div class="article-date">will <span class="month">Rent</span></div>
 <p>
    <form action="qnawritepro.bo" enctype="multipart/form-data" method="post" name="boardform">

<div class="bs-docs-section" style="align-items: center;">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-6">
            <div class="bs-component" style="width: 580px;" >
 
                <fieldset>
                
<!--                 id -->
<!--                 <div class="form-group"> -->
<!--                 <label class="col-form-label" for="inputDefault">Name</label> -->
                <input type="hidden" name="qnaBoard_id" class="form-control" placeholder="Name input"  required="required" value="<%=id%>" readonly="readonly">
<!--               </div> -->
                
                
                
                <div class="form-group">
                <label class="col-form-label" for="inputDefault">Subject</label>
                <input type="text" name="qnaBoard_subject" class="form-control" placeholder="Default input">
              </div>
                
                
                  <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="qnaBoard_pass" class="form-control" id="qnaBoard_pass" placeholder="Password">
                  </div>
                  
                  
                  <div class="form-group">
                    <label for="exampleSelect1">Tag select</label>
                    <select class="form-control" name="tag">
                    <option value="인수/반납">인수/반납</option>
                    <option value="대여안내">대여안내</option>
                    <option value="보험 및 사고">보험 및 사고</option>
                    <option value="결제/취소">결제/취소</option>
                    <option value="사이트이용">사이트이용</option>
                    </select>
                  </div>
              
              
<!--                문의내용 -->
                  <div class="form-group">
                    <label for="exampleTextarea">Substance</label>
                    <textarea name="qnaBoard_content" class="form-control" id="qnaBoard_content" rows="3"></textarea>
                  </div>
                  
                   <div class="form-group">
                  <div class="input-group mb-3">
                    <div class="custom-file">
                      <input type="file" class="custom-file-input" id="qnaBoard_file" name="qnaBoard_file">
                      <label class="custom-file-label" for="inputGroupFile02">Choose file</label>
                    </div>
                  </div>
                </div>
                    <input type="hidden" value="<%=id%>" id="id" name="id">
                  <button type="submit" class="btn btn-primary">Submit</button>
                  <button type="reset" class="btn btn-primary">reset</button>
<!--                  <a href="article-details.html" class="readmore-btn">Submit <i class="fa fa-long-arrow-right"></i></a> -->
                </fieldset>
      
            </div>
          </div>
     </div>
     </div>
     </form>
</p>








                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Articles Content End -->
                        </div>
                    </article>
                    <br>
                  <p class="thme-blockquote" style="text-align: center;">If you have any questions, please contact our customer service. Your question will be processed as quickly as possible. </p>
                </div>
                
                <!-- Single Articles End -->

                

            
            </div>

            <div class="row">

            </div>
        </div>
    </div>
    <!--== Car List Area End ==-->



        <jsp:include page="/inc/Footer.jsp"></jsp:include>

</body>

</html>