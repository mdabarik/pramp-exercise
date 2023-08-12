import java.util.*;
class Solution {
  static HashMap<String,Object> objectToHashMap(Object o) {
    HashMap x = (HashMap<Integer, String>)o;
    return x;
   }
  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    HashMap<String, String> flatDict = new HashMap<String, String>();
    helper("", dict, flatDict);
    return flatDict;
  }
  static void helper(String initialKey, HashMap<String,Object> dict, HashMap<String,String> flatDict) {
    for (String key: dict.keySet()) {
      Object value = dict.get(key);
      if (!(value instanceof HashMap<?,?>)) {
        if (key == "") {
          flatDict.put(initialKey, "" + value);
        } else if (initialKey == "") {
          flatDict.put(key, "" + value);
        } else {
          flatDict.put(initialKey + "." + key, "" + value);
        }
      } else {
        if (key=="" || initialKey=="") {
          helper(key, objectToHashMap(value), flatDict);
        } else {
          helper(initialKey+"."+key, objectToHashMap(value), flatDict);
        }
      }
    }
  }
  public static void main(String[] args) {
    /*
    Input: dict = {"Key1" : "1",
                   "Key2" : {"a" : "2",
                             "b" : "3",
                             "c" : {"d" : "3",
                                    "e" : {"" : "1"}
                                   }
                            }
                  }
    Expected Output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
                     }
    */
  }
}

/*
input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }

output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        }
*/
