package controllers;



import api.ReceiptResponse;
import api.TagResponse;
import dao.TagDao;
import dao.ReceiptDao;
import generated.tables.records.ReceiptsRecord;



import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags/{tag}")
//@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)


public class TagController {

    final TagDao tags;
    final ReceiptDao receipts;



    public TagController(TagDao tags, ReceiptDao receipts) {

        this.tags = tags;
        this.receipts = receipts;

    }

    @PUT
    public void toggleTag(@PathParam("tag") String tagName, @NotNull Integer receiptId) {

        if (!receipts.idExists(receiptId)){
            throw new WebApplicationException("receiptId does not exist", Response.Status.NOT_FOUND);
        }

        if (tags.tagged(tagName, receiptId)){
            tags.untag(tagName, receiptId);
        }else{
            tags.insert(tagName, receiptId);
        }
    }


    @GET
    public List<TagResponse> getAllReceiptsForTag(@PathParam("tag") String tagName) {
        List<ReceiptsRecord> receiptRecords = tags.getAllReceiptsForTag(tagName);
        return receiptRecords.stream().map(TagResponse::new).collect(toList());
    }

}



