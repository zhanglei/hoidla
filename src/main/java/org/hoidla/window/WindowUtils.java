/*
 * hoidla: various algorithms for Big Data solutions
 * Author: Pranab Ghosh
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.hoidla.window;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.hoidla.util.ExplicitlyTimeStamped;
import org.hoidla.util.ImplicitlyTimeStamped;
import org.hoidla.util.TimeStamped;

/**
 * @author pranab
 *
 */
public  class WindowUtils {

	/**
	 * Converts size bound window to array of doubles
	 * @param window
	 * @return array of doubles
	 */
	public static <T> double[] getDoubleArray(SizeBoundWindow<T> window) {
		double[] data = new double[window.size()];
		for (int i = 0; i < window.size(); ++i) {
			T item  = window.get(i);
			if (item instanceof Integer) {
				data[i] = (Integer)item;
			} else if (item instanceof Long) {
				data[i] = (Long)item;
			} else if (item instanceof Double) {
				data[i] = (Double)item;
			}
		}
		return data;
	}

	/**
	 * Converts size bound window to array of doubles
	 * @param window
	 * @return array of doubles
	 */
	public static <T> int[] getIntArray(SizeBoundWindow<T> window) {
		int[] data = new int[window.size()];
		for (int i = 0; i < window.size(); ++i) {
			T item  = window.get(i);
			if (item instanceof Integer) {
				data[i] = (Integer)item;
			} else if (item instanceof Long) {
				data[i] = (Integer)item;
			} else if (item instanceof Double) {
				data[i] = (Integer)item;
			}
		}
		return data;
	}

	/**
	 * Converts time bound window to array of bytes
	 * @param window
	 * @return array of doubles
	 */
	public static  double[] getDoubleArray(TimeBoundWindow window) {
		double[] data = new double[window.size()];
		for (int i = 0; i < window.size(); ++i) {
			TimeStamped timeStapmed  = window.get(i);
			Object value = null;
			if (timeStapmed instanceof ExplicitlyTimeStamped) {
				value = ((ExplicitlyTimeStamped)timeStapmed).getValue();
			} else if (timeStapmed instanceof ExplicitlyTimeStamped) {
				value = ((ImplicitlyTimeStamped)timeStapmed).getValue();
			} 
			
			//value
			if (value instanceof Integer) {
				data[i] = (Integer)value;
			} else if (value instanceof Long) {
				data[i] = (Long)value;
			} else if (value instanceof Double) {
				data[i] = (Double)value;
			}
		}
		return data;
	}
	
	/**
	 * Converts time bound window to array of bytes
	 * @param window
	 * @return array of doubles
	 */
	public static  int[] getIntArray(TimeBoundWindow window) {
		int[] data = new int[window.size()];
		for (int i = 0; i < window.size(); ++i) {
			TimeStamped timeStapmed  = window.get(i);
			Object value = null;
			if (timeStapmed instanceof ExplicitlyTimeStamped) {
				value = ((ExplicitlyTimeStamped)timeStapmed).getValue();
			} else if (timeStapmed instanceof ExplicitlyTimeStamped) {
				value = ((ImplicitlyTimeStamped)timeStapmed).getValue();
			} 
			
			//value
			if (value instanceof Integer) {
				data[i] = (Integer)value;
			} else if (value instanceof Long) {
				data[i] = (Integer)value;
			} else if (value instanceof Double) {
				data[i] = (Integer)value;
			}
		}
		return data;
	}

	/**
	 * Mean
	 * @param window
	 * @return
	 */
	public static <T> double getMean(SizeBoundWindow<T> window) {
		double[] data = getDoubleArray(window);
		return StatUtils.mean(data);
	}
	
	/**
	 * Std dev
	 * @param window
	 * @return
	 */
	public static <T> double getStdDev(SizeBoundWindow<T> window) {
		double[] data = getDoubleArray(window);
		return Math.sqrt(StatUtils.variance(data));
	}

	/**
	 * Median
	 * @param window
	 * @return
	 */
	public static <T> double getMedian(SizeBoundWindow<T> window) {
		double[] data = getDoubleArray(window);
		return StatUtils.percentile(data, 50);
	}

	/**
	 * @param window
	 * @return
	 */
	public static <T> double getEntropy(SizeBoundWindow<T> window) {
		int[] data = getIntArray(window);
		return getEntropy(data);
	}
	
	/**
	 * Mean
	 * @param window
	 * @return
	 */
	public static <T> double getMean(TimeBoundWindow window) {
		double[] data = getDoubleArray(window);
		return StatUtils.mean(data);
	}
	
	/**
	 * Std dev
	 * @param window
	 * @return
	 */
	public static double getStdDev(TimeBoundWindow window) {
		double[] data = getDoubleArray(window);
		return Math.sqrt(StatUtils.variance(data));
	}

	/**
	 * Median
	 * @param window
	 * @return
	 */
	public static double getMedian(TimeBoundWindow window) {
		double[] data = getDoubleArray(window);
		return StatUtils.percentile(data, 50);
	}

	/**
	 * @param window
	 * @return
	 */
	public static double getEntropy(TimeBoundWindow window) {
		int[] data = getIntArray(window);
		return getEntropy(data);
	}
	
	/**
	 * Mean
	 * @param window
	 * @return
	 */
	public static double getMean(double[] data) {
		return StatUtils.mean(data);
	}
	
	/**
	 * Std dev
	 * @param window
	 * @return
	 */
	public static double getStdDev(double[] data) {
		return Math.sqrt(StatUtils.variance(data));
	}

	/**
	 * Median
	 * @param window
	 * @return
	 */
	public static double getMedian(double[] data) {
		return StatUtils.percentile(data, 50);
	}
	
	/**
	 * Identifies outliers
	 * @param data
	 * @param outlierThresholdFactor
	 * @return indexes outlying data points
	 */
	public static List<Integer> removeOutliers(double[] data, int outlierThresholdFactor) {
		return removeOutliers(data, outlierThresholdFactor, null);
	}
	
	/**
	 * Identifies outliers
	 * @param data
	 * @param outlierThresholdFactor
	 * @param pattern
	 * @return indexes outlying data points
	 */
	public static List<Integer> removeOutliers(double[] data, int outlierThresholdFactor, double[] pattern) {
		if (null != pattern && data.length != pattern.length) {
			throw new IllegalArgumentException("data and pattern need to be of same size");
		}

		//stats
		SummaryStatistics stats = new SummaryStatistics();
		for (double value : data) {
			stats.addValue(value);
		}
		double mean = stats.getMean();
		double stdDev = stats.getStandardDeviation();
		
		//thresholds
		double upThreshold = mean + outlierThresholdFactor * stdDev;
		double loThreshold = mean - outlierThresholdFactor * stdDev;
		
		//detect outliers
		List<Integer> outliers = new ArrayList<Integer>();
		int i = 0;
		for (double value : data) {
			if (value > upThreshold || value < loThreshold) {
				//replace with pattern value so that there is no net effect
				if (null != pattern) {
					data[i] = pattern[i];
				}
				outliers.add(i);
			}
			++i;
		}
		
		return outliers;
	}
	
	/**
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static double manhattanDistance(double[] data, double[] pattern) {
		if (data.length != pattern.length) {
			throw new IllegalArgumentException("data and pattern need to be of same size");
		}
		double dist = 0;
		int i = 0;
		for (double value : data) {
			dist += Math.abs(value - pattern[i]);
			++i;
		}		
		dist /= data.length;
		return dist;
	}

	/**
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static double euclideanDistance(double[] data, double[] pattern) {
		if (data.length != pattern.length) {
			throw new IllegalArgumentException("data and pattern need to be of same size");
		}
		double dist = 0;
		int i = 0;
		for (double value : data) {
			dist += (value - pattern[i]) * (value - pattern[i]);
			++i;
		}		
		dist = Math.sqrt(dist) / data.length;
		return dist;
	}
	
	/**
	 * Detects change from target. Slope upward : average above target.Downward average below target
	 * @param data
	 * @param target
	 * @return
	 */
	public static double[] cumultiveDiffSum(double[] data, double target) {
		double[] cuDiffSum = new double[data.length];
		
		//cumulative sum of difference from target. 
		double sum = 0;
		for (int i = 0; i < data.length; ++i) {
			sum += data[i] - target;
			cuDiffSum[i] = sum;
		}
		return cuDiffSum;
	}
	
	/**
	 * calculates entropy
	 * @param data
	 * @return
	 */
	public static double getEntropy(int[] data) {
		double entropy = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		//freq distribution
		Frequency freq = new Frequency();
		for (int item : data) {
			freq.addValue(item);
			if (item < min){
				min = item;
			}
			if (item > max){
				max = item;
			}
		}
		
		//calculate entropy
		for (int v = min; v <= max; ++v) {
			double pr = freq.getPct(v);
			if (pr > 0) {
				entropy += -pr * Math.log(pr);
			}
		}
		
		return entropy;
	}
	
}
