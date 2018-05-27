/**
 * 
 */
package entity;

/**
 * 泛型实体类
 * @author 曾谢波
 * @since 2018年5月26日上午9:39:07
 */
public class Genericity <k, v>{
	k value1;
	v value2;
	
	/**
	 * @return the value1
	 */
	public K getValue1() {
		return value1;
	}
	/**
	 * @param value1 the value1 to set
	 */
	public void setValue1(K value1) {
		this.value1 = value1;
	}
	/**
	 * @return the value2
	 */
	public V getValue2() {
		return value2;
	}
	/**
	 * @param value2 the value2 to set
	 */
	public void setValue2(V value2) {
		this.value2 = value2;
	}
	
	
}
