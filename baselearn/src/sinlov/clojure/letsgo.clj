(ns sinlov.clojure.letsgo
  (:import (java.security MessageDigest)
           (java.util Base64)))

(defonce ^:private hash-key "universal_redis_hash_key")

(defn hash-name [k]
  (.substring ^String (:password (digest hash-key k)) 0 4))

(defn digest
  ([salt passwd]
   (digest "SHA-512" 512 salt passwd))
  ([hashalg iterations salt passwd]
   (let [jhash (MessageDigest/getInstance hashalg)
         new-pass (b64-encode (digester jhash salt passwd iterations))]
     {:salt salt :password new-pass})))

(defn- digester [^MessageDigest hasher ^String salt ^String pw-clear iter]
  {:tag String}
  (letfn [(hashme [hv]
            (letfn [(oneround [hv]
                      (do (.reset hasher)
                          (.digest hasher hv)))]
              (nth (iterate oneround hv) iter)))]
    (.reset hasher)
    (.update ^MessageDigest hasher (.getBytes salt))
    (.update ^MessageDigest hasher (.getBytes pw-clear))
    (hashme (.digest hasher))))

(defn b64-encode [^bytes b]
  {:tag String}
  (Base64/encodeBase64String b))
