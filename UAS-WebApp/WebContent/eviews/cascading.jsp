<%-- 
    Document   : cascading
    Created on : 24 Mar, 2015, 12:23:29 AM
    Author     : SARAT
--%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<script type="text/javascript" src="http://ajax.googleapis.com/
ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function ()
    {
        $("#car").change(function ()
        {
            var id = $(this).val();
            var dataString = 'id=' + id;

            $.ajax
                    ({
                        type: "POST",
                        url: "ajax.jsp",
                        data: dataString,
                        cache: false,
                        success: function (html)
                        {
                            $(".city").html(html);
                        }
                    });

        });

    });
</script>

<section id="container" >


    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">


            <select name="car" id="car">
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
               
            </select>
            <select name="city" class="city">
                <option selected="selected">--Select City--</option>
            </select>
        </section>
    </section>
</section>
