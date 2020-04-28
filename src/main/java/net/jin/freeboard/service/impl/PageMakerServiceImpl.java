package net.jin.freeboard.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.jin.freeboard.service.PageMakerService;
import net.jin.model.Freeboard;
import net.jin.pageMaker.PageMaker;

@Service
public class PageMakerServiceImpl implements PageMakerService{
	@Override
	public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Freeboard, Long> repository) {
		PageMaker pageMaker = new PageMaker();
		
		int totalCount = (int)repository.count();
		pageMaker.setTotalcount(totalCount);//전체 게시글 수를 지정한다
		pageMaker.setPagenum(pageNum-1);//현재 페이지를 페이지 객체에 지정한다. -1을 해야 쿼리에서 사용할 수 있다
		pageMaker.setContentnum(contentNum);//한페이지에서 몇개씩 게시글을 보여줄지 지정한다
		pageMaker.setCurrentblock(pageNum);//현재페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
		pageMaker.setLastblock(pageMaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다
		pageMaker.prevNext(pageNum);//현재 페이지 번호로 화살표를 나타낼지 정한다
		pageMaker.setStartPage(pageMaker.getCurrentblock());//시작페이지를 페이지 블록 번호로 정한다
		pageMaker.setEndPage(pageMaker.getLastblock(),pageMaker.getCurrentblock());//마지막페이지를 마지막페이지블록과 현재 페이지블록 번호로 정한다
		
		return pageMaker;
	}

}
