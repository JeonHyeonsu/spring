
package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.NonNull;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {

		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);

		return "안녕하세요11";

	}
	
	// 교재와 다른 부분 내용 추가!
	// spring 5.2에서 MediaType.APPLICATION_JSON_UTF8_VALUE 는 제거됨
	// 해당 값 없어도 현재 브라우저는 UTF-8을 제대로 처리함.
	// spring 5.2 부터 MediaType.APPLICATION_JSON_UTF8 로 수정하면됨
	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_VALUE,
												   MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {

		return new SampleVO(112, "스타", "로드");

	}

	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}

	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		
		// 기존 방식의 code
//		List<SampleVO> sample_list = new ArrayList<>();
//		for(int i=0; i < 10; i++) {
//			sample_list.add(i, new SampleVO(i, i + "First", i + " Last"));
//		}
//		return sample_list;
		
		// 람다식 code (java 1.8이상 지원)
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + " Last"))
				.collect(Collectors.toList());

	}

	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {

		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));

		return map;
		
	}

	@GetMapping(value = "/check", params = { "height", "weight" })
	// @GetMapping(value = "/check") // params = 를 제거해도 "height", "weight" 파라미터는 정사적으로 수집된다. 
	// params는 해당 파라미터가 필수라는 의미. 해당 파라미터가 넘어오지 않으면 오류처리됨!!
	// params가 없는 상태에서 해당 파라미터가 넘어오지 않으면 null 값이 들어감.
	public ResponseEntity<SampleVO> check(Double height, Double weight) {

		SampleVO vo = new SampleVO(0, "" + height, "" + weight);

		ResponseEntity<SampleVO> result = null;

		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}

		return result;
	}
	
	@GetMapping(value = "/check2")
	public ResponseEntity<SampleVO> check2(@NonNull Double height, @NonNull Double weight) {

		SampleVO vo = new SampleVO(0, "" + height, "" + weight);

		ResponseEntity<SampleVO> result = null;

		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}

		return result;
	}

	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {

		return new String[] { "category: " + cat, "productid: " + pid };
	}

	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {

		log.info("convert.......ticket" + ticket);

		return ticket;

	}

}
