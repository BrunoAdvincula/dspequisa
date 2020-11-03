import React, { useEffect, useState } from 'react';
import Filters from '../../components/Filters';
import './styles.css'
import { barOptions, pieOptions } from './charts-opitons';
import Chart from 'react-apexcharts';
import Axios from 'axios';
import {buildBarSeries,getPlatformChartData,getGenderChartData} from './helpers'
type PieChartData = {
    labels:string[];
    series:number[];
}

type BarChartData = {
    x:string;
    y:number;
}

const initialPieData = {
    labels:[],
    series:[]
}
const BASE_URL = 'http://localhost:8080';
const Charts = () => {
    const [barChartData, setBarChartData] = useState<BarChartData[]>([]);
    const [piedChartData, setPieChartData] = useState<PieChartData>(initialPieData);
    const [genderChartData, setGenderChartData] = useState<PieChartData>(initialPieData);

    useEffect(()=>{
      async  function getData(){
            const recordsResponse = await Axios.get(`${BASE_URL}/records`);
            const gamesResponse = await Axios.get(`${BASE_URL}/games`);
            const barData = buildBarSeries(gamesResponse.data,recordsResponse.data.content);
            setBarChartData(barData);

            const platformChartData = getPlatformChartData(recordsResponse.data.content);
            setPieChartData(platformChartData);
            const genderChartData = getGenderChartData(recordsResponse.data.content);
            setGenderChartData(genderChartData);
        }
        getData();
    },[])
    return (
        <div className="page-container">
            <Filters link="./records" linkText="VER TABELA" />
            <div className="chart-container">
                <div className="top-related">
                    <h1 className="top-related-title">Jogos mais votados</h1>
                    <div className="games-container">
                        <Chart
                            options={barOptions}
                            type="bar"
                            width="900"
                            height="500"
                            series={[{ data: barChartData }]}
                        />

                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title">Platforms</h2>
                        <Chart
                            options={{...pieOptions, labels:piedChartData?.labels}}
                            type="donut"
                            series={piedChartData?.series}
                            width="350"
                        />
                    </div>
                    <div className="gender-chart">
                        <h2 className="chart-title">Gêneros</h2>
                        <Chart
                            options={{...pieOptions, labels:genderChartData?.labels}}
                            type="donut"
                            series={genderChartData?.series}
                            width="350"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
}
export default Charts;