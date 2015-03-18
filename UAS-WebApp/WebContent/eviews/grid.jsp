<!--<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>-->
<!-- The jQuery library is a prerequisite for all jqSuite products -->
<!-- <script type="text/javascript" src="js/jquery.min.js"></script>  -->
<!-- This is the Javascript file of jqGrid -->   
<script type="text/javascript" src="eviews/assets/js/jquery.jqGrid.min.js"></script>
<!-- This is the localization file of the grid controlling messages, labels, etc.
<!-- We support more than 40 localizations -->
<script type="text/javascript" src="eviews/assets/js/i18n/grid.locale-en.js"></script>
<!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
<link rel="stylesheet" type="text/css"  href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<!-- The link to the CSS that the grid needs -->
<link rel="stylesheet" type="text/css" href="eviews/assets/css/ui.jqgrid.css" />
<meta charset="utf-8" />
<title>jqGrid Loading Data - Dialogs - Edit, Add, Delete</title>

<section id="main-content">
    <section class="wrapper">
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>

        <script type="text/javascript">

            $(document).ready(function () {
                $("#jqGrid").jqGrid({
                    url: 'eviews/data/data.json',
                    // we set the changes to be made at client side using predefined word clientArray
                    editurl: 'http://localhost:8084/UAS_WebApp/courseAction.do?method=gridExample',
                    datatype: "json",
                    colModel: [
                        {
                            label: 'Customer ID',
                            name: 'CustomerID',
                            width: 75,
                            key: true,
                            editable: true,
                            editrules: {required: true}
                        },
                        {
                            label: 'Company Name',
                            name: 'CompanyName',
                            width: 140,
                            editable: true // must set editable to true if you want to make the field editable
                        },
                        {
                            label: 'Phone',
                            name: 'Phone',
                            width: 100,
                            editable: true
                        },
                        {
                            label: 'Postal Code',
                            name: 'PostalCode',
                            width: 80,
                            editable: true
                        },
                        {
                            label: 'City',
                            name: 'City',
                            width: 140,
                            editable: true
                        }
                    ],
                    sortname: 'CustomerID',
                    sortorder: 'asc',
                    loadonce: true,
                    viewrecords: true,
                    width: 780,
                    height: 200,
                    rowNum: 10,
                    pager: "#jqGridPager"
                });

                $('#jqGrid').navGrid('#jqGridPager',
                        // the buttons to appear on the toolbar of the grid
                                {edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false},
                        // options for the Edit Dialog
                        {
                            editCaption: "The Edit Dialog",
                            recreateForm: true,
                            checkOnUpdate: true,
                            checkOnSubmit: true,
                            closeAfterEdit: true,
                            errorTextFormat: function (data) {
                                return 'Error: ' + data.responseText
                            }
                        },
                        // options for the Add Dialog
                        {
                            closeAfterAdd: true,
                            recreateForm: true,
                            errorTextFormat: function (data) {
                                return 'Error: ' + data.responseText
                            }
                        },
                        // options for the Delete Dailog
                        {
                            errorTextFormat: function (data) {
                                return 'Error: ' + data.responseText
                            }
                        });
                    });

        </script>
    </section>
</section>
