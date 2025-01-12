package com.niyaj.neetcode

import java.util.*

/**
 * Time Based Key-Value Store
 * Solved
 * Implement a time-based key-value data structure that supports:
 *
 * Storing multiple values for the same key at specified time stamps
 * Retrieving the key's value at a specified timestamp
 * Implement the TimeMap class:
 *
 * TimeMap() Initializes the object.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns the most recent value of key if set was previously called on it and the most recent timestamp for that key prev_timestamp is less than or equal to the given timestamp (prev_timestamp <= timestamp). If there are no values, it returns "".
 * Note: For all calls to set, the timestamps are in strictly increasing order.
 *
 * Example 1:
 *
 * Input:
 * ["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]
 *
 * Output:
 * [null, null, "happy", "happy", null, "sad"]
 *
 * Explanation:
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
 * timeMap.get("alice", 1);           // return "happy"
 * timeMap.get("alice", 2);           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
 * timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
 * timeMap.get("alice", 3);           // return "sad"
 * Constraints:
 *
 * 1 <= key.length, value.length <= 100
 * key and value only include lowercase English letters and digits.
 * 1 <= timestamp <= 1000
 */
object TimeBasedKeyValueStore {
    // Initialize a map m to store the key value pair with timestamp
    private val m = HashMap<String, TreeMap<Int, String>>()

    /**
     * Set the key value pair with timestamp
     * Step1: Initialize a map m
     * Step2: Store the key value pair with timestamp in the map
     * Step3: Return null
     * Time complexity: O(1)
     * Space complexity: O(n)
     */
    fun set(key: String, value: String, timestamp: Int) {
        m.computeIfAbsent(key){ TreeMap() }[timestamp] = value
    }

    /**
     * Get the value of the key at the specified timestamp
     * Step1: Get the tree map for the key
     * Step2: Get the entry for the timestamp
     * Step3: Return the value
     * Time complexity: O(log n)
     * Space complexity: O(1)
     */
    fun get(key: String, timestamp: Int): String {
        val treeMap = m[key] ?: return ""
        val entry = treeMap.floorEntry(timestamp)
        return entry?.value ?: ""
    }
}

fun main() {
    val timeMap = TimeBasedKeyValueStore
    timeMap.set("alice", "happy", 1)
    println(timeMap.get("alice", 1)) // happy
    println(timeMap.get("alice", 2)) // happy
    timeMap.set("alice", "sad", 3)
    println(timeMap.get("alice", 3)) // sad
}