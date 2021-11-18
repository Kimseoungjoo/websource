package board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 페이지 나누기와 관련된 정보 
public class PageDTO {
	// searchDTO도 가지고 들어와야한다
	private SearchDTO searchDto; // 검색기준
	
	private int startPage; 	// 시작페이지
	private int endPage; 	// 마지막 페이지
	private boolean prev; 	// 이전버튼 활성화 여부
	private boolean next; 	// 다음버튼 활성화 여부
	private int total; 		// 전체 게시물
	
	private int page; // 현재 페이지 번호(페이지를 몇번을 눌렀는지)
	private int amount;	// 페이지당 게시물 갯수 (10)=> 변경이 가능하도록 변수로 잡아뒀다.
	
	public PageDTO(int total, int page, int amount, SearchDTO searchDto) {
		super();
		this.total = total;
		this.page = page;
		this.amount = amount;
		this.searchDto = searchDto; 
		
		// 마지막 페이지 계산
		endPage = (int)(Math.ceil(this.page/10.0))*10;
		// 시작 페이지 계산
		startPage = endPage-9;
		
		// 끝나는 페이지는 10가 안될 수도 있기 때문에 다시 계산
		int readEnd = (int)(Math.ceil((this.total/1.0)/this.amount));
		
		if(readEnd < this.endPage) {
			this.endPage = readEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < readEnd;
		
	}
}
