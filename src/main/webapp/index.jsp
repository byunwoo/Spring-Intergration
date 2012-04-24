<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!--<meta http-equiv="refresh" content="3;url=http://www.naver.com">-->
<%--response.sendRedirect("http://www.naver.com");--%>
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="/js/three.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(){
/* 		alert(tttt.rows.length+"/"+tttt.cells.length);
		tttt.deleteRow(3);
		alert(tttt.rows.length+"/"+tttt.cells.length);
		alert(ssss);
		
		ie 만 먹는다...
 */		
		init();
	    animate();
	});
	function test(){
		$.getJSON("/empsJson", {}, function(availability) {
			var table = "<div><table>";
			$.each(availability, function(idx,row){
				table += "<tr>";
				table +=     "<td>"+row.empNo+"</td>";
				table +=     "<td>"+row.ename+"</td>";
				table += "</tr>";
			});
			table += "</table></div>";
			
			$("#jsonResult").replaceWith(table);
		    /* if (availability.available) {
		        fieldValidated("name", { valid : true });
		    } else {
		        fieldValidated("name", { valid : false,
		            message : $('#name').val() + " is not available, try " + availability.suggestions });
		    }*/
		}); 
	}
	
    var camera, scene, renderer,
    geometry, material, mesh;

    function init() {

        scene = new THREE.Scene();

        camera = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 1, 10000 );
        camera.position.z = 1000;
        scene.add( camera );

        geometry = new THREE.CubeGeometry( 200, 200, 200 );
        material = new THREE.MeshBasicMaterial( { color: 0xff0000, wireframe: true } );

        mesh = new THREE.Mesh( geometry, material );
        scene.add( mesh );

        renderer = new THREE.CanvasRenderer();
        renderer.setSize( window.innerWidth, window.innerHeight );

        document.body.appendChild( renderer.domElement );

    }

    function animate() {

        // note: three.js includes requestAnimationFrame shim
        requestAnimationFrame( animate );
        render();

    }

    function render() {

        mesh.rotation.x += 0.01;
        mesh.rotation.y += 0.02;

        renderer.render( scene, camera );

    }
</script>
<body>
	<b>Spring</b><br/>
	<ul>
		<li>
			<a href="/test">internalResouceViewResolver 와  DefaultAnnotationHandlerMapping 으로 동작하는 링크</a>
		</li>
		<li>
			<a href="/simpleUrlHandlerMapping/test">xmlViewResolver 와  SimpleUrlHandlerMapping 으로 동작하는 링크</a>
		</li>
		<li>
			<a href="/empList">EMP List</a>
		</li>
		<li>
			<a href="javascript:test();" >EMP List Json 리턴</a>
			<div id="jsonResult"></div>
		</li>
		<li>
			<a href="/mongo">MongoDb Controller</a>
		</li>
		<li><a href="auth.jsp">인증결과</a></li>
		<li><a href="/j_spring_security_logout">로그아웃</a></li>
	</ul>
</body>
</html>