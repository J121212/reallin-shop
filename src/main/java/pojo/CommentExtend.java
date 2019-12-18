package pojo;

/**
 * Created by pc on 2019/10/11.
 */
import java.util.List;

public class CommentExtend extends Goods{
    private List<Comments> comments;
    public List<Comments> getComments() {
        return comments;
    }
    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }


}
