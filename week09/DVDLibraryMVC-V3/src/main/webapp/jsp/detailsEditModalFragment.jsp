<!-- Details Modal -->
<div class="modal fade" id="details-modal" tabindex="-1" role="dialog"
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
                        <td id="dvd-title" style="text-decoration: underline;"></td>
                        <td rowspan="5" style="width: 30%;">
                            <img id="dvd-image" class="img-responsive" src="">
                        </td>
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
                        <th>Synopsis:</th>
                        <td colspan="2" id="dvd-overview" style="font-style: italic;"></td>
                    </tr>
                    <tr>
                        <th>User Note:</th>
                        <td colspan="2" id="dvd-note"></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Edit Modal -->
<div class="modal fade" id="edit-modal" tabindex="-1" role="dialog"
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
                            <div id="error-modal-title" class="validationErrors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-year" class="col-md-4 control-label">
                            Year:
                        </label>
                        <div class="col-md-8">
                            <input type="number" min="1878" max="2100" class="form-control" id="edit-year"
                                   placeholder="Year">
                            <div id="error-modal-year" class="validationErrors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-mpaa" class="col-md-4 control-label">
                            MPAA Rating:
                        </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-mpaa"
                                   placeholder="MPAA Rating">
                            <div id="error-modal-mpaa" class="validationErrors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-director" class="col-md-4 control-label">
                            Director:
                        </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-director"
                                   placeholder="Director">
                            <div id="error-modal-director" class="validationErrors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-studio" class="col-md-4 control-label">
                            Producer:
                        </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-studio"
                                   placeholder="Producer">
                            <div id="error-modal-studio" class="validationErrors"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-note" class="col-md-4 control-label">
                            Note:
                        </label>
                        <div class="col-md-8">
                            <textarea class="form-control" id="edit-note"
                                      placeholder="Note"></textarea>
                            <input type="hidden" id="edit-id" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="edit-button" class="btn btn-primary">
                                Update
                            </button>
                            <button type="button" id="edit-button-cancel" class="btn btn-default"
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