<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search/">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayDVDLibraryNoAjax/">DVD Library (No Ajax)</a></li>
                </ul>    
            </div>

            <div class="row">
                <div class="col-md-8">
                    <h2 class="text-center">DVDs</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="22%">Title</th>
                            <th width="8%">Year</th>
                            <th width="8%">MPAA</th>
                            <th width="14%">Director</th>
                            <th width="15%">Producer</th>
                            <th width="27%">Note</th>
                            <th width="8%"></th>
                        </tr>

                        <tbody id="contentRows"></tbody>

                    </table>
                </div>

                <div class="col-md-4">
                    <h2 class="text-center">Add New DVD</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-3 control-label">
                                Title
                            </label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-title"
                                       placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-year" class="col-md-3 control-label">
                                Year:
                            </label>
                            <div class="col-md-9">
                                <input type="number"
                                       min="1878"
                                       max="2100"
                                       class="form-control"
                                       id="add-year"
                                       placeholder="Year"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-mpaa" class="col-md-3 control-label">
                                MPAA Rating:
                            </label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-mpaa"
                                       placeholder="MPAA"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-3 control-label">Director:</label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-director"
                                       placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-studio" class="col-md-3 control-label">Studio:</label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-note" class="col-md-3 control-label">Note:</label>
                            <div class="col-md-9">
                                <textarea class="form-control" id="add-note" placeholder="Note"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Add
                                </button>
                            </div>
                        </div>
                    </form>
                </div> <!-- End col div -->
            </div> <!-- End row div --> 
        </div>

        <!-- Details Modal -->
        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">DVD Details</h4>
                    </div>
                    <div class="modal-body">
                        <table class="table table-bordered">
                            <tr>
                                <th>Title:</th>
                                <td id="dvd-title"></td>
                            </tr>
                            <tr>
                                <th>Year:</th>
                                <td id="dvd-year"></td>
                            </tr>
                            <tr>
                                <th>MPAA Rating:</th>
                                <td id="dvd-mpaa"></td>
                            </tr>
                            <tr>
                                <th>Director:</th>
                                <td id="dvd-director"></td>
                            </tr>
                            <tr>
                                <th>Producer:</th>
                                <td id="dvd-studio"></td>
                            </tr>
                            <tr>
                                <th>Note:</th>
                                <td id="dvd-note"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Edit Modal -->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="detailsModalLabel">Edit DVD</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-title" class="col-md-4 control-label">
                                    Title:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-title"
                                           placeholder="Title">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-year" class="col-md-4 control-label">
                                    Year:
                                </label>
                                <div class="col-md-8">
                                    <input type="number" min="1878" max="2100" class="form-control" id="edit-year"
                                           placeholder="Year">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-mpaa" class="col-md-4 control-label">
                                    MPAA Rating:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-mpaa"
                                           placeholder="MPAA Rating">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-director" class="col-md-4 control-label">
                                    Director:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-director"
                                           placeholder="Director">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-studio" class="col-md-4 control-label">
                                    Producer:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-studio"
                                           placeholder="Producer">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-note" class="col-md-4 control-label">
                                    Note:
                                </label>
                                <div class="col-md-8">
                                    <textarea class="form-control" id="edit-note"
                                              placeholder="Note"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="edit-button" class="btn btn-default"
                                            data-dismiss="modal">
                                        Update DVD
                                    </button>
                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" id="edit-id">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdLibrary.js"></script>
    </body>
</html>

