package practice.design.observer;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:35
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
