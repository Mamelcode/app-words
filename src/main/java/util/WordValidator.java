package util;

import java.util.HashMap;
import java.util.Map;

import api.OpenDicAPI;
import data.GameData;
import data.search.SearchResult;
import repository.GameDatas;

public class WordValidator {
	
	public static int execute(String roomId, String word) {
		Map map = new HashMap();
		map.put("roomId", roomId);
		map.put("word", word);
		
		GameData found = GameDatas.readByWord(map);
		if(found != null) {
			return 1;
		}
		
		SearchResult rst = OpenDicAPI.search(word);
		if(rst.getChannel().getTotal() == 0) {
			return 2;
		}
		
		GameData latest =GameDatas.readLatest(roomId);
		if(!latest.getWord().endsWith(word.substring(0,1))) {

			return 3;
		}
		
		return 0;
	}
}
