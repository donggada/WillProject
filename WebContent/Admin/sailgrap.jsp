
<%@page import="admin.vo.CarBean"%>
<%@page import="book.vo.BookBean"%>
<%@page import="qna.vo.pageinfo"%>
<%@page import="member.vo.MemberBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%
    	//ArrayList<BookBean> bookList = (ArrayList<BookBean>) request.getAttribute("bookList");
// 	pageinfo pageiInfo = (pageinfo)request.getAttribute("pageInfo");
	

// 	int listCount = pageiInfo.getListcount();
// 	int nowPage = pageiInfo.getPage(); 
// 	int startPage = pageiInfo.getStartpage();
// 	int endPage = pageiInfo.getEndpage();
// 	int maxPage = pageiInfo.getMaxpage();

ArrayList<CarBean> cb=(ArrayList)request.getAttribute("SalesList");
//system.out.print(cb);
ArrayList target=new ArrayList();
ArrayList count= new ArrayList();
if(cb!=null){
for(int i = 0; i < cb.size(); i++){
	target.add("'"+cb.get(i).getCar_name()+"'");
	count.add(cb.get(i).getCar_id());
	//system.out.print(cb.get(i).getCar_id());
	 }
}
%>

<!DOCTYPE html>
<html>
 <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin</title>
        <link href="Admin/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
     <link href="QnA/QnA11/bootstrap.css" rel="stylesheet">
 <link href="QnA/QnA11/bootstrap.min.css" rel="stylesheet">
   

<!-- Resources -->
<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>
   
   
    </head>
<style>
#chartdiv {
  width: 100%;
  height: 600px;
}

</style>
    
    <jsp:include page="/inc/topleft.jsp"></jsp:include>
    
    
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Sale Top5List</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">ADMIN MAIN</a></li>
                            <li class="breadcrumb-item active">CarSailList</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                               -
                                <a target="_blank" href="#">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                Sail List
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                
                                    
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
      
   
<script>

am4core.ready(function() {
 
	
	var target=<%=target%>
	var count=<%=count%>
	
	
// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

/**
 * Chart design taken from Samsung health app
 */

var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

chart.paddingRight = 40;

chart.data= chart.data =  [{
    "name": target[4],
    "steps": count[4],
    "href":"ChartCarimg/"+target[4]+".png"
}, {
  	 "name": target[3],
    "steps": count[3],
    "href": "ChartCarimg/"+target[3]+".png"
}, {
    "name": target[2],
    "steps": count[2],
    "href": "ChartCarimg/"+target[2]+".png"
}, {
    "name": target[1],
    "steps": count[1],
    "href": "ChartCarimg/"+target[1]+".png"
}, {
    "name": target[0],
    "steps": count[0],
    "href": "ChartCarimg/"+target[0]+".png"
}];


var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "name";
categoryAxis.renderer.grid.template.strokeOpacity = 0;
categoryAxis.renderer.minGridDistance = 10;
categoryAxis.renderer.labels.template.dx = -40;
categoryAxis.renderer.minWidth = 120;
categoryAxis.renderer.tooltip.dx = -40;

var valueAxis = chart.xAxes.push(new am4charts.ValueAxis());
valueAxis.renderer.inside = true;
valueAxis.renderer.labels.template.fillOpacity = 0.3;
valueAxis.renderer.grid.template.strokeOpacity = 0;
valueAxis.min = 0;
valueAxis.cursorTooltipEnabled = false;
valueAxis.renderer.baseGrid.strokeOpacity = 0;
valueAxis.renderer.labels.template.dy = 20;

var series = chart.series.push(new am4charts.ColumnSeries);
series.dataFields.valueX = "steps";
series.dataFields.categoryY = "name";
series.tooltipText = "{valueX.value}";
series.tooltip.pointerOrientation = "vertical";
series.tooltip.dy = - 30;
series.columnsContainer.zIndex = 100;

var columnTemplate = series.columns.template;
columnTemplate.height = am4core.percent(50);
columnTemplate.maxHeight = 50;
columnTemplate.column.cornerRadius(60, 10, 60, 10);
columnTemplate.strokeOpacity = 0;

series.heatRules.push({ target: columnTemplate, property: "fill", dataField: "valueX", min: am4core.color("#e5dc36"), max: am4core.color("#5faa46") });
series.mainContainer.mask = undefined;

var cursor = new am4charts.XYCursor();
chart.cursor = cursor;
cursor.lineX.disabled = true;
cursor.lineY.disabled = true;
cursor.behavior = "none";

var bullet = columnTemplate.createChild(am4charts.CircleBullet);
bullet.circle.radius = 30;
bullet.valign = "middle";
bullet.align = "left";
bullet.isMeasured = true;
bullet.interactionsEnabled = false;
bullet.horizontalCenter = "right";
bullet.interactionsEnabled = false;

var hoverState = bullet.states.create("hover");
var outlineCircle = bullet.createChild(am4core.Circle);
outlineCircle.adapter.add("radius", function (radius, target) {
    var circleBullet = target.parent;
    return circleBullet.circle.pixelRadius + 10;
})

var image = bullet.createChild(am4core.Image);
image.width = 60;
image.height = 60;
image.horizontalCenter = "middle";
image.verticalCenter = "middle";
image.propertyFields.href = "href";

image.adapter.add("mask", function (mask, target) {
    var circleBullet = target.parent;
    return circleBullet.circle;
})

var previousBullet;
chart.cursor.events.on("cursorpositionchanged", function (event) {
    var dataItem = series.tooltipDataItem;

    if (dataItem.column) {
        var bullet = dataItem.column.children.getIndex(1);

        if (previousBullet && previousBullet != bullet) {
            previousBullet.isHover = false;
        }

        if (previousBullet != bullet) {

            var hs = bullet.states.getKey("hover");
            hs.properties.dx = dataItem.column.pixelWidth;
            bullet.isHover = true;

            previousBullet = bullet;
        }
    }
})

}); // end am4core.ready()
</script>

<!-- HTML -->
<div id="chartdiv"></div>

     
     
                                        
                                        
                                        
                                        
                                    </table>
                                    
   
   
                
                                    
                                    
  
                                </div>
                            </div>
                        </div>
                    </div>
                </main>



            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="Admin/js/scripts.js"></script>
<!--         <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script> -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="Admin/assets/demo/datatables-demo.js"></script>
    </body>
    
    


</html>