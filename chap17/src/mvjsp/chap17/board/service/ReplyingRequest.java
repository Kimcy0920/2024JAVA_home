package mvjsp.chap17.board.service;

public class ReplyingRequest extends WritingRequest {

	
	public ReplyingRequest(String writerName, String password, String title, String content, int parentArticleId,
			String p) {
		super(writerName, password, title, content);
		this.parentArticleId = parentArticleId;
		this.p = p;
	}
	private int parentArticleId;
	private String p;
	
	public int getParentArticleId() {
		return parentArticleId;
	}
	public void setParentArticleId(int parentArticleId) {
		this.parentArticleId = parentArticleId;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	
}
