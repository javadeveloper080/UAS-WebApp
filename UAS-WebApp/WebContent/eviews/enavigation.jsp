<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            
            <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                
                
                
                
                
                
                
            <li class="sub-menu">
                <a href="javascript:;"  id="FeeModuleNav">
                    <i class="fa fa-th"></i>
                    <span>Fee Module</span>
                </a>
                    
                <ul class="sub">
                    <li id="FeeTypeNav"><a  href="typeTableAction.do?method=feeTypePage" onclick="highlightNavTree('FeeType');" >Fee Type</a></li>
                    <li><a  href="typeTableAction.do?method=feeCategoryTypePage">Fee Category Type</a></li>
                </ul>
            </li>
                
                
                
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
    
<script>
    function highlightNavTree(navId) {
        alert('clicked nav tree'+navId);
        if(navId=='FeeType'){
            alert('Inside nav tree ');
          document.getElementById("FeeTypeNav").className="active";
             document.getElementById("FeeModuleNav").className="active";
        }
    }
</script>