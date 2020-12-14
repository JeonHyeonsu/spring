<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="header.jsp"%>
<section class="container">
    <!--위젯 상단 3개-->
    <div class="row">
        <div class="col-md-8">
            <div class="row">
                <article class="col-md-12 news-card">
                    <a href="">
                        <div class="news-card-title">
                            <img src="/resources/img/twilight-wings-debut-169-en.jpg" alt="">
                        </div>
                        <div class="news-footer news-footer-yellow">
                            <h3>Watch Episode 6 of <em>Pokémon: Twilight Wings</em> Now</h3>
                            <p>Allister helps out some feuding friends in the latest episode of this animated series now
                                on Pokémon TV and YouTube.</p>
                        </div>
                    </a>
                </article>
            </div>
        </div>
        <div class="col-md-4">
            <div class="row">
                <article class="col-md-12 news-card">
                    <a href="/front/rank">
                        <div class="news-card-title">
                            <img src="/resources/img/rank.jpg" alt="">
                        </div>
                        <div class="news-footer news-footer-brown">
                            <h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp< ★랭킹★ > </h3>
                        </div>
                    </a>
                </article>
                <article class="col-md-12 news-card">
                    <a href="/front/userRegister">
                        <div class="news-card-title news-card-right">
                            <img src="/resources/img/quizmake.png" alt="">
                        </div>
                        <div class="news-footer news-card-right news-footer-green">
                            <h3>퀴즈 제작</h3>
                        </div> 
                    </a>
                </article>
            </div>
        </div>
    </div>
    <!--위젯 중단 3개-->
    <div class="row">
        <article class="col-md-4 news-card">
            <a href="/front/quiz_jp">
                <div class="news-card-title">
                    <img src="/resources/img/quiz_jp.jpg" alt="">
                </div>
                <div class="news-footer news-footer-gray">
                    <h3>面白い日本語クイズです。</h3>
                </div>
            </a>
        </article>
        <article class="col-md-4 news-card">
            <a href="/front/quiz_ns">
                <div class="news-card-title">
                    <img src="/resources/img/quiz_ns.jpg" alt="">
                </div>
                <div class="news-footer news-footer-black">
                    <h3>재미있는 넌센스 퀴즈입니다.</h3>
                </div>
            </a>
        </article>
        <article class="col-md-4 news-card">
            <a href="/front/quiz_cm">
                <div class="news-card-title">
                    <img src="/resources/img/quiz_cm.jpg" alt="">
                </div>
                <div class="news-footer news-footer-blue">
                    <h3>조금은 어려운 상식 퀴즈입니다.</h3>
                </div>
            </a>
        </article>

    </div>
</section>
<%@include file="footer.jsp"%>