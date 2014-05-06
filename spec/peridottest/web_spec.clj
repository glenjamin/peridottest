(ns peridottest.web-spec
  (:require [speclj.core :refer :all]
            [peridot.core :refer :all]
            [peridottest.web :refer [app]]))

(describe "peridottest.web"
  (context "/"
    (it "parses params"
      (should= "{\"b\" \"2\", \"a\" \"1\"}"
               (get-in (-> (session app)
                           (request "/" :request-method :get
                                        :params {"a" "1"
                                                 "b" "2"}))
                       [:response :body])))))
