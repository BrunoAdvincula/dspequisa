import React from 'react';
import {ReactComponent as Seta} from '../../assests/seta.svg';
import {ReactComponent as Gamer} from '../../assests/gamer.svg';
import './styles.css';
const Home = () => (
    <div className="home-container">
        <div className="home-text">
            <h1 className="home-text-title">Quais jogos a galera gosta mais?</h1>
            <h3 className="home-text-subtitle">Clique no botão abaixo e saiba quais são os jogos que os gamers estão escolhendo!</h3>
            <div className="home-actions">
                <button className="home-btn">
                    QUERO SABER QUAIS SÃO
                </button>
                <div className="home-btn-icon">
                    <Seta/>
                </div>
            </div>
        </div>
        <Gamer/>
    </div>
);
export default Home;